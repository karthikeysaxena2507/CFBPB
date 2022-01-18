package ConsumerFinancing.service;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.entity.Income;
import ConsumerFinancing.entity.Lender;
import ConsumerFinancing.model.criterion.extended.ExtendedLenderData;
import ConsumerFinancing.model.criterion.extended.ExtendedLenderInfo;
import ConsumerFinancing.model.criterion.preApproval.PreLenderInfo;
import ConsumerFinancing.model.customers.Customer;
import ConsumerFinancing.model.finances.Finance;
import ConsumerFinancing.model.rates.Rates;
import ConsumerFinancing.repository.IncomeRepository;
import ConsumerFinancing.repository.LenderRepository;
import ConsumerFinancing.util.FormulaeUtil;
import ConsumerFinancing.util.LenderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RatesService extends AppConfig {

    private final FinanceService financeService;
    private final CustomerService customerService;
    private final FormulaeUtil formulaeUtil;
    private final IncomeRepository incomeRepository;
    private final RedisService redisService;
    private final LenderRatesService lenderRatesService;
    private final LenderRepository lenderRepository;
    private final LenderUtil lenderUtil;

    public RatesService(
            FinanceService financeService,
            FormulaeUtil formulaeUtil,
            IncomeRepository incomeRepository,
            CustomerService customerService,
            RedisService redisService,
            LenderRatesService lenderRatesService,
            LenderRepository lenderRepository,
            LenderUtil lenderUtil) {
        this.incomeRepository = incomeRepository;
        this.financeService = financeService;
        this.formulaeUtil = formulaeUtil;
        this.redisService = redisService;
        this.customerService = customerService;
        this.lenderRatesService = lenderRatesService;
        this.lenderRepository = lenderRepository;
        this.lenderUtil = lenderUtil;
    }

    public ExtendedLenderData getRates(Finance finance, String hashKey, String key) {

        log.info("Finance Details are: \n {}", finance);
        financeService.addFinanceToRedis(hashKey, key, finance);

        Customer customer = customerService.getCustomerFromRedis(hashKey, key);
        log.info("Customer Details are: \n {}", customer);
        modifyExpensesToMonthlyFrequency(finance);

        int hemMonthlyExpense = getMonthlyExpenses(finance);
        log.info("hemMonthlyExpense is {}", hemMonthlyExpense);
        int userMonthlyExpense = finance.getExpenses().getTotalExpense();
        log.info("userMonthlyExpense is {}", userMonthlyExpense);
        int monthlyExpense = Integer.max(hemMonthlyExpense, userMonthlyExpense);
        log.info("Monthly Expense is {}", monthlyExpense);

        int monthlyIncome = lenderUtil.getMonthlyIncome(
                finance.getPersonalDetails().getIncomeDetails().getIncome(),
                finance.getPersonalDetails().getIncomeDetails().getIncomeFrequency()
        );
        log.info("Monthly Income is {}", monthlyIncome);

        Rates rates = new Rates();
        rates.setHemMonthlyExpenses(hemMonthlyExpense);
        rates.setUserMonthlyExpenses(userMonthlyExpense);
        rates.setRepaymentFrequency(customer.getVehicle().getRepaymentFrequency());
        log.info("Rates is {}", rates);

        addRatesToRedis(hashKey, key, rates);

        List<ExtendedLenderInfo> extendedLenderInfoList = getExtendedLenderInfoList(
                hashKey, key, customer, monthlyIncome, monthlyExpense);

        return new ExtendedLenderData(rates, extendedLenderInfoList);
    }

    public List<ExtendedLenderInfo> getExtendedLenderInfoList(
            String hashKey, String key,
            Customer customer,
            Integer monthlyIncome,
            Integer monthlyExpense) {

        List<PreLenderInfo> lenders =
                lenderRatesService.getPreLenderInfoListFromRedis(hashKey, key);
        Finance finance = financeService.getFinanceFromRedis(hashKey, key);
        List<ExtendedLenderInfo> extendedLenderInfoList = new ArrayList<>();
        for (PreLenderInfo lender: lenders) {
            ExtendedLenderInfo extendedLender = new ExtendedLenderInfo();

            extendedLender.setLenderName(lender.getLenderName());
            extendedLender.setInterestRate(lender.getInterestRate());

            double monthlyRepayments = getRepayments(
                    lender.getLenderName(),
                    lender.getInterestRate(),
                    finance, customer
            );
            if (monthlyRepayments > 0) {
                double nsr = formulaeUtil.nsr(
                        monthlyIncome, monthlyExpense, monthlyRepayments);
                extendedLender.setNsrValue(nsr);
            }
            else {
                extendedLender.setNsrValue(0.0);
            }

            boolean isLenderValid = isExtendedLenderValid(extendedLender, finance);
            if (!lender.getIsLenderValid()) {
                extendedLender.setIsLenderValid(false);
            }

            extendedLender.setIsLenderValid(isLenderValid);
            extendedLenderInfoList.add(extendedLender);
        }
        lenderRatesService.addExtendedLenderInfoListToRedis(
                hashKey, key, extendedLenderInfoList);
        return extendedLenderInfoList;
    }

    public Boolean isExtendedLenderValid(
            ExtendedLenderInfo extendedLender,
            Finance finance) {

        String lenderName = extendedLender.getLenderName();
        Lender lender = lenderRepository.findById(lenderName).orElseThrow();

        boolean isValid = true;

        /* SCORECARD */

        /* ANNUAL INCOME */
        if (lenderUtil.isAnnualIncomeValid(lender, finance)) {
            extendedLender.setIsAnnualIncomeValid(VALID);
        }
        else {
            isValid = false;
            extendedLender.setIsAnnualIncomeValid(INVALID);
        }

        /* EMPLOYMENT TENURE */
        if (lenderUtil.isEmploymentTenureValid(lender.getLenderName(), finance)) {
            extendedLender.setIsEmploymentTenureValid(VALID);
        }
        else {
            isValid = false;
            extendedLender.setIsEmploymentTenureValid(INVALID);
        }

        /* USER SERVICEABILITY RATIO */
        if (lenderUtil.isUserServiceabilityValid(lender, extendedLender)) {
            extendedLender.setIsUserServiceabilityValid(VALID);
        }
        else {
            isValid = false;
            extendedLender.setIsUserServiceabilityValid(INVALID);
        }

        /* KNOCKOUTS */

        /* DRIVING LICENSE */
        extendedLender.setIsDrivingLicenseValid(NOT_DECIDED);

        return isValid;
    }

    public Rates getRatesFromRedis(String hashKey, String key) {
        key = key + RATES_KEY;
        return (Rates) redisService.getKeyValue(hashKey, key);
    }

    public void addRatesToRedis(String hashKey, String key, Object value) {
        key = key + RATES_KEY;
        redisService.addKeyValue(hashKey, key, value);
    }

    private double getRepayments(
            String lenderName, Double interestRate, Finance finance, Customer customer) {
        double liabilityRepayments = finance.getLiabilities().getTotalRepayments();
        double creditCardBalance = finance.getLiabilities().getTotalCreditCardBalance();
        double monthlyRepayment = (double) formulaeUtil.getLoanRepayment(
                lenderName, interestRate, MONTHLY,  customer);
        return liabilityRepayments + creditCardBalance * 0.038 + monthlyRepayment;
    }

    private int getMonthlyExpenses(Finance finance) {

        List<Income> incomes = new ArrayList<>();
        String suburb = finance.getPersonalDetails().getSuburb();
        String state = finance.getPersonalDetails().getState();
        Integer income = finance.getPersonalDetails().getIncomeDetails().getIncome();
        String incomeFrequency = finance
                .getPersonalDetails().getIncomeDetails().getIncomeFrequency();

        finance.getPersonalDetails().getIncomeDetails().setIncome(
                lenderUtil.getAnnualIncome(income, incomeFrequency));
        finance.getPersonalDetails().getIncomeDetails().setIncomeFrequency(ANNUALLY);

        if (SUBURBS.contains(suburb)) {
            log.info("Suburb is {}", suburb);
            incomes = incomeRepository.getMonthlyExpenses(
                    finance.getPersonalDetails().getIncomeDetails().getIncome(),
                    suburb,
                    getRelationshipStatus(finance.getPersonalDetails().getRelationshipStatus()),
                    finance.getPersonalDetails().getNumberOfDependents()
            );
        }
        else if (STATES.contains(state)) {
            log.info("State is {}", state);
            incomes = incomeRepository.getMonthlyExpenses(
                    finance.getPersonalDetails().getIncomeDetails().getIncome(),
                    state,
                    getRelationshipStatus(finance.getPersonalDetails().getRelationshipStatus()),
                    finance.getPersonalDetails().getNumberOfDependents()
            );
        }
        log.info("Incomes are: {} \n", incomes);
        return incomes.isEmpty() ? 0 : incomeRepository
                .getTotalMonthlyExpenses(
                        incomes.get(0),
                        finance.getPersonalDetails().getNumberOfDependents()
                );
    }

    private String getRelationshipStatus(String relationshipStatus) {
        return (relationshipStatus.equals(MARRIED)) ? COUPLE : SINGLE;
    }

    private void modifyExpensesToMonthlyFrequency(Finance finance) {

        // MORTGAGE
        int expense = finance.getExpenses().getMortgageExpense().getExpense();
        String frequency = finance.getExpenses().getMortgageExpense().getFrequency();
        finance.getExpenses().getMortgageExpense().setExpense(
                lenderUtil.getMonthlyIncome(expense, frequency));
        finance.getExpenses().getMortgageExpense().setFrequency(MONTHLY);

        // FOOD AND GROCERIES
        expense = finance.getExpenses().getFoodAndGroceries().getExpense();
        frequency = finance.getExpenses().getFoodAndGroceries().getFrequency();
        finance.getExpenses().getFoodAndGroceries().setExpense(
                lenderUtil.getMonthlyIncome(expense, frequency));
        finance.getExpenses().getFoodAndGroceries().setFrequency(MONTHLY);

        // HEALTH AND EDUCATION
        expense = finance.getExpenses().getHealthAndEducation().getExpense();
        frequency = finance.getExpenses().getHealthAndEducation().getFrequency();
        finance.getExpenses().getHealthAndEducation().setExpense(
                lenderUtil.getMonthlyIncome(expense, frequency));
        finance.getExpenses().getHealthAndEducation().setFrequency(MONTHLY);

        // UTILITY
        expense = finance.getExpenses().getUtility().getExpense();
        frequency = finance.getExpenses().getUtility().getFrequency();
        finance.getExpenses().getUtility().setExpense(
                lenderUtil.getMonthlyIncome(expense, frequency));
        finance.getExpenses().getUtility().setFrequency(MONTHLY);

        // ENTERTAINMENT
        expense = finance.getExpenses().getEntertainment().getExpense();
        frequency = finance.getExpenses().getEntertainment().getFrequency();
        finance.getExpenses().getEntertainment().setExpense(
                lenderUtil.getMonthlyIncome(expense, frequency));
        finance.getExpenses().getEntertainment().setFrequency(MONTHLY);

        // OTHER EXPENSE
        expense = finance.getExpenses().getOtherExpense().getExpense();
        frequency = finance.getExpenses().getOtherExpense().getFrequency();
        finance.getExpenses().getOtherExpense().setExpense(
                lenderUtil.getMonthlyIncome(expense, frequency));
        finance.getExpenses().getOtherExpense().setFrequency(MONTHLY);

        // TRANSPORT
        expense = finance.getExpenses().getTransport().getExpense();
        frequency = finance.getExpenses().getTransport().getFrequency();
        finance.getExpenses().getTransport().setExpense(
                lenderUtil.getMonthlyIncome(expense, frequency));
        finance.getExpenses().getTransport().setFrequency(MONTHLY);
    }

}
