package ConsumerFinancing.service;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.entity.Lender;
import ConsumerFinancing.entity.LenderRate;
import ConsumerFinancing.equifax.models.model.Response;
import ConsumerFinancing.equifax.models.model.ScoreType;
import ConsumerFinancing.equifax.service.EquifaxService;
import ConsumerFinancing.model.criterion.extended.ExtendedLenderInfo;
import ConsumerFinancing.model.customers.Customer;
import ConsumerFinancing.model.criterion.preApproval.PreLenderInfo;
import ConsumerFinancing.model.criterion.preApproval.PreLenderData;
import ConsumerFinancing.repository.LenderRateRepository;
import ConsumerFinancing.repository.LenderRepository;
import ConsumerFinancing.util.FormulaeUtil;
import ConsumerFinancing.util.LenderUtil;
import ConsumerFinancing.util.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Slf4j
@Service
public class LenderRatesService extends AppConfig {

    private final LenderRateRepository lenderRateRepository;
    private final LenderRepository lenderRepository;
    private final UploadUtil uploadUtil;
    private final RedisService redisService;
    private final CustomerService customerService;
    private final FormulaeUtil formulaeUtil;
    private final LenderUtil lenderUtil;
    private final EquifaxService equifaxService;

    public LenderRatesService(
            LenderRateRepository lenderRateRepository,
            UploadUtil uploadUtil,
            LenderRepository lenderRepository,
            RedisService redisService,
            CustomerService customerService,
            FormulaeUtil formulaeUtil,
            LenderUtil lenderUtil,
            EquifaxService equifaxService) {

        this.lenderRateRepository = lenderRateRepository;
        this.uploadUtil = uploadUtil;
        this.lenderRepository = lenderRepository;
        this.redisService = redisService;
        this.customerService = customerService;
        this.formulaeUtil = formulaeUtil;
        this.lenderUtil = lenderUtil;
        this.equifaxService = equifaxService;
    }

    public List<LenderRate> uploadLenderRates(MultipartFile file, Integer sheetNumber)
            throws IOException {

        Supplier<Stream<Row>> rowStreamSupplier = uploadUtil.getRowStreamSupplier(
                file, sheetNumber);

        List<Row> rows = uploadUtil.getRows(rowStreamSupplier);
        List<LenderRate> lenderRates = new ArrayList<>();

        for (Row row: rows) {
            LenderRate lenderRate = new LenderRate();
            lenderRate.setLenderName(row.getCell(0).getStringCellValue());
            lenderRate.setLivingStatus(row.getCell(1).getStringCellValue());
            lenderRate.setInterestRate(row.getCell(2).getNumericCellValue());
            lenderRate.setMinCreditScore((int) row.getCell(3).getNumericCellValue());
            lenderRate.setMaxCreditScore((int) row.getCell(4).getNumericCellValue());
            lenderRate.setAssetAge((int) row.getCell(5).getNumericCellValue());
            lenderRates.add(lenderRate);
        }

        log.info("count of ExtendedLender Rates is: {}", lenderRates.size());
        log.info("\n ExtendedLender Rates are: {}", lenderRates);
        return lenderRateRepository.saveAll(lenderRates);
    }

    public PreLenderData getPreLenders(
            Customer customer, String hashKey, String key) {

        log.info("Customer is {}", customer);

        if (!key.isBlank() && redisService.contains(hashKey, key + PRE_LENDER_KEY)) {
            log.info("Pre Lender Details present in cache");
            return new PreLenderData(key, getPreLenderInfoListFromRedis(hashKey, key));
        }

        String redisKey = UUID.randomUUID().toString()
                .replaceAll("-", "").substring(0, 6);
        customerService.addCustomerToRedis(hashKey, redisKey, customer);

        /* UPDATING CREDIT SCORE FROM EQUIFAX */
        Response response = equifaxService.getEquifaxResponse(hashKey, redisKey);
        List<ScoreType> scores = equifaxService.getCreditScore(response);
        if (!scores.isEmpty()) {
            int creditScore = Integer.parseInt(scores.get(0).getScoreMasterscale());
            log.info("Credit Score from equifax is {}", creditScore);
            customer.getPersonal().setCreditScore(creditScore);
            customerService.addCustomerToRedis(hashKey, redisKey, customer);
        }

        List<PreLenderInfo> preLenderInfoList = new ArrayList<>();
        List<Lender> lenders = lenderRepository.findAll();

        for (Lender lender: lenders) {

            PreLenderInfo preLenderInfo = new PreLenderInfo();

            preLenderInfo.setLenderName(lender.getLenderName());
            boolean isLenderValid = isPreLenderValid(customer, preLenderInfo);

            if (!equifaxService.areEquifaxFieldsValid(response, preLenderInfo, customer)) {
                isLenderValid = false;
            }

            preLenderInfo.setIsLenderValid(isLenderValid);

            if (isLenderValid) {

                /* INTEREST RATE */
                double interestRate = getInterestRate(customer, lender.getLenderName());
                preLenderInfo.setInterestRate(interestRate);
                log.info("Interest Rate is {}", interestRate);

                /* COMPARISON RATE */
                double comparisonRate = formulaeUtil.getComparisonRate(
                        lender.getLenderName(), interestRate);
                preLenderInfo.setComparisonRate(comparisonRate);
                log.info("Comparison Rate is {}", comparisonRate);

                /* LOAN REPAYMENT */
                int loanRepayment = (int) formulaeUtil.getLoanRepayment(
                        lender.getLenderName(), interestRate,
                        customer.getVehicle().getRepaymentFrequency(), customer);
                preLenderInfo.setLoanRepayment(loanRepayment);
                log.info("Loan Repayment is {}", loanRepayment);

            }
            else {
                preLenderInfo.setInterestRate(0.0);
                preLenderInfo.setLoanRepayment(0);
                preLenderInfo.setComparisonRate(0.0);
            }
            preLenderInfoList.add(preLenderInfo);
        }
        log.info("Pre Approved Lenders are {}", preLenderInfoList);
        addPreLenderInfoListToRedis(hashKey, redisKey, preLenderInfoList);
        return new PreLenderData(redisKey, preLenderInfoList);
    }

    public double getInterestRate(Customer customer, String lenderName) {
        int assetAge = getCurrentYear() - customer.getVehicle().getVehicleYear();
        int creditScore = customer.getPersonal().getCreditScore();
        List<LenderRate> lenderRates = lenderRateRepository
                .getLenderRates(HOME_OWNER, lenderName, assetAge, creditScore);
        log.info("Rates are: {} and \n size: {}", lenderRates, lenderRates.size());
        if (lenderRates.isEmpty()) return 0.0;
        else return lenderRates.get(0).getInterestRate();
    }

    private boolean isPreLenderValid(
            Customer customer, PreLenderInfo preLenderInfo) {

        Lender lender = lenderRepository.findById(preLenderInfo.getLenderName()).orElseThrow();
        boolean isValid = true;

        /* SCORECARD */

        /* CREDIT SCORE VALIDITY */
        if (lenderUtil.isCreditScoreValid(lender, customer)) {
            preLenderInfo.setIsCreditScoreValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsCreditScoreValid(INVALID);
        }

        /* RESIDENCY STABILITY */
        if (lenderUtil.isLivingStatusValid(customer)) {
            preLenderInfo.setIsResidenceStable(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsResidenceStable(INVALID);
        }

        /* KNOCKOUTS */
        /* AGE VALIDITY */
        if (lenderUtil.isAgeValid(lender, customer)) {
            preLenderInfo.setIsAgeValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsAgeValid(INVALID);
        }

        /* RESIDENCY STATUS VALIDITY */
        if (lenderUtil.isResidencyStatusValid(lender, customer)) {
            preLenderInfo.setIsResidencyStatusValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsResidencyStatusValid(INVALID);
        }

        /* EMPLOYMENT STATUS VALIDITY */
        if (!lenderUtil.isEmploymentStatusValid(customer)) {
            preLenderInfo.setIsEmploymentStatusValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsEmploymentStatusValid(INVALID);
        }

        /* LOAN TERMS */

        /* LOAN AMOUNT VALIDITY */
        if (lenderUtil.isLoanAmountValid(lender, customer)) {
            preLenderInfo.setIsLoanAmountValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsLoanAmountValid(INVALID);
        }

        /* LOAN TERM VALID */
        if (lenderUtil.isLoanTermValid(lender, customer)) {
            preLenderInfo.setIsLoanTermValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsLoanTermValid(INVALID);
        }

        /* REPAYMENT FREQUENCY */
        if (lenderUtil.isRepaymentFrequencyValid(lender, customer)) {
            preLenderInfo.setIsRepaymentFrequencyValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsRepaymentFrequencyValid(INVALID);
        }

        /* VEHICLE AGE */
        if (lenderUtil.isVehicleAgeValid(lender, customer)) {
            preLenderInfo.setIsVehicleAgeValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsVehicleAgeValid(INVALID);
        }

        /* BALLOON */
        if (lenderUtil.isBalloonValid(customer, lender.getLenderName())) {
            preLenderInfo.setIsBalloonValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsBalloonValid(INVALID);
        }

        /* ODOMETER READING */
        if (lenderUtil.isOdometerReadingValid()) {
            preLenderInfo.setIsOdometerReadingValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsOdometerReadingValid(INVALID);
        }

        /* LOAN TO VALUE RATIO */
        if (lenderUtil.isLvrValid(customer, lender.getLenderName())) {
            preLenderInfo.setIsLvrValid(VALID);
        }
        else {
            isValid = false;
            preLenderInfo.setIsLvrValid(INVALID);
        }

        return isValid;
    }

    public List<PreLenderInfo> getPreLenderInfoListFromRedis(String hashKey, String key) {
        key = key + PRE_LENDER_KEY;
        return (List<PreLenderInfo>) redisService.getKeyValue(hashKey, key);
    }

    public List<ExtendedLenderInfo> getExtendedLenderInfoListFromRedis(String hashKey, String key) {
        key = key + EXTENDED_LENDER_KEY;
        return (List<ExtendedLenderInfo>) redisService.getKeyValue(hashKey, key);
    }

    public void addPreLenderInfoListToRedis(String hashKey, String key, Object value) {
        log.info("Pre Lender Info List Added to Redis");
        key = key + PRE_LENDER_KEY;
        redisService.addKeyValue(hashKey, key, value);
    }

    public void addExtendedLenderInfoListToRedis(String hashKey, String key, Object value) {
        log.info("Extended Lender Info List Added to Redis");
        key = key + EXTENDED_LENDER_KEY;
        redisService.addKeyValue(hashKey, key, value);
    }

    private Integer getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

}
