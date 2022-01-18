package ConsumerFinancing.util;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.entity.Lender;
import ConsumerFinancing.equifax.models.model.CharacteristicType;
import ConsumerFinancing.illion.model.Metrics;
import ConsumerFinancing.model.criterion.extended.ExtendedLenderInfo;
import ConsumerFinancing.model.customers.Customer;
import ConsumerFinancing.model.finances.Finance;
import ConsumerFinancing.service.LenderFeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class LenderUtil extends AppConfig {

    private final FormulaeUtil formulaeUtil;
    private final LenderFeeService feeService;

    public LenderUtil(
            FormulaeUtil formulaeUtil,
            LenderFeeService feeService) {
        this.formulaeUtil = formulaeUtil;
        this.feeService = feeService;
    }

    public String isAdverseFileValid(
            Map<String, CharacteristicType> map, String lender) {
        CharacteristicType type = map.get("NX7601");
        String value = type.getValue().getValue();
        if (lender.equals(FIRSTMAC)) {
            return value.equals("N") ? VALID : NOT_DECIDED;
        }
        return VALID;
    }

    public String isCreditFileAgeValid(
            Map<String, CharacteristicType> map, String lender, Customer customer) {

        int fileAge = (int) Math.ceil(Double.parseDouble(map.get("NA8902").getValue().getValue()) / 12);
        log.info("File Age is {}", fileAge);
        int applicantAge = getAgeFromDateOfBirth(customer.getPersonal().getDateOfBirth());
        log.info("Applicant Age is {}", applicantAge);
        int repaymentStatus = Integer.parseInt(map.get("CX0184").getValue().getValue());
        int loan = customer.getVehicle().getVehiclePrice() - customer.getVehicle().getDeposit();
        log.info("loan is {}", loan);
        switch (lender) {
            case WISR:
                if (fileAge > 18 || applicantAge > 26) return VALID;
                else if (fileAge >= 12 && repaymentStatus <= 0) return NOT_DECIDED;
                else return INVALID;
            case FIRSTMAC:
                return (fileAge >= 6) ? VALID : NOT_DECIDED;
            case PLENTI:
                return (fileAge >= 12) ? VALID : INVALID;
            case AUTOPAY:
                return (fileAge <= 12 && loan > 20000) ? NOT_DECIDED : VALID;
            default:
                return VALID;
        }
    }

    public String isMaxRhiMostRecentValid(
            Map<String, CharacteristicType> map, String lender) {

        int accounts1 = Integer.parseInt(map.get("CX0096").getValue().getValue());
        int accounts2 = Integer.parseInt(map.get("CX0095").getValue().getValue());
        switch (lender) {
            case WISR:
                return (accounts1 > 0) ? INVALID : VALID;
            case FIRSTMAC:
                return (accounts2 > 0) ? INVALID : VALID;
            default:
                return VALID;
        }
    }

    public String isMaxRhi3monthsValid(
            Map<String, CharacteristicType> map, String lender) {
        return VALID;
    }

    public String isMaxRhi12monthsValid(
            Map<String, CharacteristicType> map, String lender) {

        String value = map.get("CX0185").getValue().getValue();
        List<String> allowedValues = List.of("2", "3", "4", "5", "6", "X");
        if (lender.equals(PLENTI)) {
            return (allowedValues.contains(value)) ? INVALID : VALID;
        }
        return VALID;
    }

    public String isMaxRhi24monthsValid(
            Map<String, CharacteristicType> map, String lender) {
        return VALID;
    }

    public String isInsolvencyValid(
            Map<String, CharacteristicType> map, String lender) {

        int value = Integer.parseInt(map.get("NP8510").getValue().getValue());
        return (value > 0) ? INVALID : VALID;
    }

    public String isFinancialDFValid(
            Map<String, CharacteristicType> map, String lender) {

        int amount = Integer.parseInt(map.get("NX7586").getValue().getValue());
        if (lender.equals(WISR)) {
            return (amount > 1000) ? INVALID : VALID;
        }
        return (amount > 0) ? INVALID : VALID;
    }

    public String isNonFinancialDFValid(
            Map<String, CharacteristicType> map, String lender) {

        int amount = Integer.parseInt(map.get("NX7585").getValue().getValue());
        switch (lender) {
            case WISR:
            case FIRSTMAC:
                return (amount > 1000) ? INVALID : VALID;
            case PLENTI:
                return (amount > 500) ? INVALID : VALID;
            case AUTOPAY:
                return (amount > 0) ? INVALID : VALID;
            default:
                return VALID;
        }
    }

    public String isOtherCourtActionsValid(
            Map<String, CharacteristicType> map, String lender) {

        int courtWrits = Integer.parseInt(map.get("NP7511").getValue().getValue());
        int judgements = Integer.parseInt(map.get("NP7504").getValue().getValue());
        return (courtWrits > 0 || judgements > 0) ? INVALID : VALID;
    }

    public boolean isServiceabilityValid(
            String lender, Double interestRate, Customer customer, Map<String, Metrics> metricsMap) {

        double monthlyAffordable = Double.parseDouble((String) metricsMap.get("DA001").getValue());
        log.info("monthly Affordability is {}", monthlyAffordable);
        double monthlyPmt = formulaeUtil.getLoanRepayment(lender, interestRate, MONTHLY, customer);
        log.info("monthly pmt is {}", monthlyPmt);
        double monthlyIncome = Double.parseDouble((String) metricsMap.get("DM001").getValue())
                + Double.parseDouble((String) metricsMap.get("DM002").getValue());
        log.info("monthly income is {}", monthlyIncome);
        switch (lender) {
            case WISR:
            case FIRSTMAC:
                return monthlyAffordable / monthlyPmt >= 1.01;
            case PLENTI:
                return monthlyPmt <= 0.2 * (monthlyIncome);
            default:
                return true;
        }
    }

    public boolean isGamblingAmountValid(String lender, Map<String, Metrics> metricsMap) {
        double gamblingPercentage = Double.parseDouble((String) metricsMap.get("CF005").getValue());
        log.info("Gambling Percentage is {}", gamblingPercentage);
        double gamblingExpense = Double.parseDouble((String) metricsMap.get("DM007").getValue());
        log.info("Gambling Expense is {}", gamblingExpense);
        switch (lender) {
            case WISR:
                return gamblingPercentage <= 30 && gamblingExpense * 3 < 5000;
            case PLENTI:
                return gamblingPercentage <= 50;
            case AUTOPAY:
                return gamblingPercentage <= 40;
            default:
                return true;
        }
    }

    public boolean areDishonoursValid(
            String lender, Integer creditScore, Map<String, Metrics> metricsMap) {

        Map<String, Integer> monthMap = (Map<String, Integer>) metricsMap.get("BF013").getValue();
        int totalDishonours = 0;
        switch (lender) {
            case WISR:
                for (int i = 1; i <= 3; i++) {
                    totalDishonours += monthMap.get("Month " + i);
                }
                log.info("Total Dishonours: {}", totalDishonours);
                return totalDishonours <= 4 && creditScore >= 640;
            case PLENTI:
                for (int i = 2; i <= 5; i++) {
                    if (monthMap.get("Month " + i) > 0 &&
                        monthMap.get("Month " + (i - 1)) > 0 &&
                        monthMap.get("Month " + (i + 1)) > 0) {
                        return false;
                    }
                }
                return true;
            default:
                return true;
        }
    }

    public boolean arePayDayLoansValid(String lender, Map<String, Metrics> metricsMap) {
        Map<String, Integer> monthMap = (Map<String, Integer>) metricsMap.get("BF016").getValue();
        int payDayDishonours = (int) metricsMap.get("DM005").getValue();
        int totalLoans = 0;
        switch (lender) {
            case WISR:
                for (int i = 1; i <= 3; i++) {
                    totalLoans += monthMap.get("Month " + i);
                }
                log.info("Total Loans: {}", totalLoans);
                return totalLoans < 2 && payDayDishonours == 0;
            case PLENTI:
                for (int i = 1; i <= 6; i++) {
                    totalLoans += monthMap.get("Month " + i);
                }
                log.info("Total Loans: {}", totalLoans);
                return totalLoans == 0;
            default:
                return true;
        }
    }

    public boolean isEmploymentTenureValid(String lender, Finance finance) {
        int fullTime = finance.getPersonalDetails().getExperience().getFullTime();
        int partTime = finance.getPersonalDetails().getExperience().getPartTime();
        String employmentType = finance.getPersonalDetails().getIncomeDetails().getCurrentEmploymentType();
        int current = finance.getPersonalDetails().getExperience().getCurrent();
        switch (lender) {
            case WISR:
                switch (employmentType) {
                    case FULL_TIME:
                        return current + fullTime >= 6;
                    case PART_TIME:
                        return current + partTime >= 6;
                    case CASUAL:
                        return current >= 9;
                    case SELF_EMPLOYED:
                        return current >= 24;
                    default:
                        return false;
                }
            case FIRSTMAC:
                switch (employmentType) {
                    case FULL_TIME:
                    case PART_TIME:
                    case CONTRACT:
                        return current >= 6;
                    case CASUAL:
                        return current >= 12;
                    case SELF_EMPLOYED:
                        return current >= 24;
                    default:
                        return false;
                }
            case PLENTI:
            case AUTOPAY:
                switch (employmentType) {
                    case FULL_TIME:
                        return current >= 3;
                    case PART_TIME:
                        return current >= 6;
                    case CASUAL:
                    case SELF_EMPLOYED:
                        return current >= 12;
                    default:
                        return false;
                }
            default:
                return true;
        }
    }

    public boolean isUserServiceabilityValid(
            Lender lender, ExtendedLenderInfo extendedLender) {
        double nsr = extendedLender.getNsrValue();
        switch (lender.getLenderName()) {
            case WISR:
            case FIRSTMAC:
                return nsr >= 1.01;
            default:
                return true;
        }
    }

    public boolean isAnnualIncomeValid(Lender lender, Finance finance) {
        int annualIncome = getAnnualIncome(
                finance.getPersonalDetails().getIncomeDetails().getIncome(),
                finance.getPersonalDetails().getIncomeDetails().getIncomeFrequency()
        );
        return annualIncome >= lender.getMinAnnualIncome();
    }

    public boolean isEmploymentStatusValid(Customer customer) {
        String employmentStatus = customer.getPersonal().getEmploymentStatus();
        return employmentStatus.equals(UNEMPLOYED);
    }

    public boolean isResidencyStatusValid(Lender lender, Customer customer) {
        String residence = customer.getPersonal().getResidencyStatus();
        return lender.getResidencyStatuses().contains(residence);
    }

    public boolean isAgeValid(Lender lender, Customer customer) {
        int age = getAgeFromDateOfBirth(customer.getPersonal().getDateOfBirth());
        return lender.getMinAge() <= age && age <= lender.getMaxAge();
    }

    public boolean isLivingStatusValid(Customer customer) {
        String livingStatus = customer.getPersonal().getLivingStatus();
        return getHomeOwnershipStatus(livingStatus).equals(HOME_OWNER);
    }

    public boolean isCreditScoreValid(Lender lender, Customer customer) {
        int creditScore = customer.getPersonal().getCreditScore();
        return (lender.getMinCreditScore() <= creditScore &&
                creditScore <= lender.getMaxCreditScore());
    }

    public boolean isLoanAmountValid(Lender lender, Customer customer) {
        int loanAmount = customer.getVehicle().getVehiclePrice()
                - customer.getVehicle().getDeposit();
        if (loanAmount < 0) loanAmount = 0;
        return lender.getMinLoanAmount() <= loanAmount &&
                loanAmount <= lender.getMaxLoanAmount();
    }

    public boolean isLoanTermValid(Lender lender, Customer customer) {
        int loanTerm = customer.getVehicle().getLoanTerm();
        return lender.getAllowedLoanTerms().contains(loanTerm);
    }

    public boolean isRepaymentFrequencyValid(Lender lender, Customer customer) {
        String repaymentFrequency = customer.getVehicle().getRepaymentFrequency();
        return lender.getRepaymentFrequencies().contains(repaymentFrequency);
    }

    public boolean isVehicleAgeValid(Lender lender, Customer customer) {
        int vehicleAge = getCurrentYear() - customer.getVehicle().getVehicleYear();
        int loanTerm = customer.getVehicle().getLoanTerm();
        if (lender.getLenderName().equals(AUTOPAY)) {
            return (vehicleAge + loanTerm) <= 20;
        }
        return vehicleAge <= 12 && (vehicleAge + loanTerm) <= 15;
    }

    public boolean isBalloonValid(Customer customer, String lender) {
        int balloon = customer.getVehicle().getEndOfLoanPayment();
        int vehicleAge = getCurrentYear() - customer.getVehicle().getVehicleYear();
        int loanTerm = customer.getVehicle().getLoanTerm();
        String residencyStatus = customer.getPersonal().getResidencyStatus();
        switch (lender) {
            case WISR:
            case PLENTI:
                return balloon > 0;
            case FIRSTMAC:
                if (!residencyStatus.equals("Temporary Visa") && vehicleAge < 4) {
                    switch (loanTerm) {
                        case 3:
                            return balloon < 40;
                        case 4:
                            return balloon < 30;
                        case 5:
                            return balloon < 20;
                        default:
                            return false;
                    }
                }
                else {
                    return false;
                }
            case AUTOPAY:
                switch (loanTerm) {
                    case 3:
                        if (vehicleAge <= 5) return balloon <= 40;
                        else if (vehicleAge <= 7) return balloon <= 30;
                        else return balloon <= 0;
                    case 4:
                        if (vehicleAge <= 5) return balloon <= 35;
                        else if (vehicleAge == 6) return balloon <= 20;
                        else return balloon <= 0;
                    case 5:
                        if (vehicleAge <= 5) return balloon <= 30;
                        else return balloon <= 0;
                    case 6:
                        if (vehicleAge <= 4) return balloon <= 25;
                        else return balloon <= 0;
                    case 7:
                        if (vehicleAge <= 3) return balloon <= 25;
                        else return balloon <= 0;
                    default:
                        return false;
                }
            default:
                return true;
        }
    }

    public boolean isLvrValid(Customer customer, String lender) {
        int loan = customer.getVehicle().getVehiclePrice() - customer.getVehicle().getDeposit();
        int vehicleAge = getCurrentYear() - customer.getVehicle().getVehicleYear();
        int loanTerm = customer.getVehicle().getLoanTerm();
        int value = customer.getVehicle().getValue();
        int fees = feeService.getLenderFees(loan, lender);
        int creditScore = customer.getPersonal().getCreditScore();
        double lvr = ((double) (loan + fees)) / ((double) value);
        log.info("LVR is {}", lvr);
        switch (lender) {
            case WISR:
                if ((vehicleAge + loanTerm) > 11) {
                    return lvr <= 1.5;
                }
                else if ((vehicleAge + loanTerm) <= 11) {
                    return lvr <= 1.3;
                }
                else {
                    return false;
                }
            case FIRSTMAC:
                return lvr <= 1.2;
            case PLENTI:
                if (creditScore >= 600) {
                    return lvr <= 1.4;
                }
                else {
                    return lvr <= 1.15;
                }
            case AUTOPAY:
                return lvr <= 1.3;
            default:
                return true;
        }
    }

    public boolean isOdometerReadingValid() {
        return true;
    }

    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    private String getHomeOwnershipStatus(String livingStatus) {
        return HOME_OWNERS.contains(livingStatus) ? HOME_OWNER : NON_HOME_OWNER;
    }

    private int getAgeFromDateOfBirth(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(date, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);
        return period.getYears();
    }

    public int getAnnualIncome(Integer income, String frequency) {
        int annualIncome = income;
        log.info("Before Annual conversion: {}", annualIncome);
        switch (frequency) {
            case WEEKLY:
                annualIncome = income * 52;
                break;
            case FORTNIGHTLY:
                annualIncome = income * 26;
                break;
            case MONTHLY:
                annualIncome = income * 12;
                break;
            default:
        }
        log.info("After Annual conversion: {}", annualIncome);
        return annualIncome;
    }

    public int getMonthlyIncome(Integer income, String frequency) {
        int monthlyIncome = income;
        log.info("Before Monthly conversion: {}", monthlyIncome);
        switch (frequency) {
            case WEEKLY:
                monthlyIncome = (income * 52) / 12;
                break;
            case FORTNIGHTLY:
                monthlyIncome = (income * 26) / 12;
                break;
            case ANNUALLY:
                monthlyIncome = income / 12;
                break;
            default:
        }
        log.info("After Monthly conversion: {}", monthlyIncome);
        return monthlyIncome;
    }

}
