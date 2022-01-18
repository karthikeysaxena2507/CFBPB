package ConsumerFinancing.illion.service;

import ConsumerFinancing.illion.config.IllionConfig;
import ConsumerFinancing.illion.model.*;
import ConsumerFinancing.model.criterion.extended.ExtendedLenderInfo;
import ConsumerFinancing.model.customers.Customer;
import ConsumerFinancing.service.CustomerService;
import ConsumerFinancing.service.LenderRatesService;
import ConsumerFinancing.util.LenderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class IllionService extends IllionConfig {

    private final RestTemplate restTemplate;
    private final LenderRatesService lenderRatesService;
    private final LenderUtil lenderUtil;
    private final CustomerService customerService;

    public IllionService(
            RestTemplate restTemplate,
            LenderRatesService lenderRatesService,
            LenderUtil lenderUtil,
            CustomerService customerService) {

        this.restTemplate = restTemplate;
        this.lenderRatesService = lenderRatesService;
        this.lenderUtil = lenderUtil;
        this.customerService = customerService;
    }

    public List<ExtendedLenderInfo> getUpdatedExtendedLenders(User user, String hashKey, String key) {

        Response response = getBankStatements(user);
        List<ExtendedLenderInfo> extendedLenderInfoList =
                lenderRatesService.getExtendedLenderInfoListFromRedis(hashKey, key);

        List<Metrics> decisionMetrics = response.getDecisionMetrics();
        Map<String, Metrics> metricsMap = new HashMap<>();

        for (Metrics metric: decisionMetrics) {
            metricsMap.put(metric.getId(), metric);
        }

        for (ExtendedLenderInfo lenderInfo: extendedLenderInfoList) {
            if (!areIllionFieldsValid(lenderInfo, metricsMap, hashKey, key)) {
                lenderInfo.setIsLenderValid(false);
            }
        }

        lenderRatesService.addExtendedLenderInfoListToRedis(hashKey, key, extendedLenderInfoList);

        return extendedLenderInfoList;
    }

    private Response getBankStatements(User user) {

        HttpHeaders headers = getBasicHttpHeaders();
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        UserResponse userResponse
                = restTemplate.postForObject(getLoginUri(), entity, UserResponse.class);
        log.info("User Response  is {}", userResponse);

        Map<String, List<Integer>> accounts = new HashMap<>();
        List<Integer> ids = new ArrayList<>();

        assert userResponse != null;
        for (Account account: userResponse.getAccounts()) {
            ids.add(account.getId());
        }
        log.info("Account IDs are: {}", ids);

        accounts.put(user.getCredentials().getInstitution(), ids);
        UserAccounts userAccounts = new UserAccounts(accounts, userResponse.getUser_token());
        log.info("User Accounts are: {}", userAccounts);

        HttpEntity<UserAccounts> httpEntity = new HttpEntity<>(userAccounts, headers);
        Response response = restTemplate.postForObject(getStatementsUri(), httpEntity, Response.class);
        log.info("Response is {}", response);

        return response;

    }

    private boolean areIllionFieldsValid(
            ExtendedLenderInfo extendedLenderInfo,
            Map<String, Metrics> metricsMap,
            String hashKey, String key) {

        boolean isValid = true;
        String lender = extendedLenderInfo.getLenderName();
        Customer customer = customerService.getCustomerFromRedis(hashKey, key);
        int creditScore = customer.getPersonal().getCreditScore();
        double interestRate = extendedLenderInfo.getInterestRate();

        /* SERVICEABILITY */
        if (lenderUtil.isServiceabilityValid(lender, interestRate, customer, metricsMap)) {
            extendedLenderInfo.setIsServiceabilityValid(VALID);
        }
        else {
            isValid = false;
            extendedLenderInfo.setIsServiceabilityValid(INVALID);
        }

        /* DISHONOURS */
        if (lenderUtil.areDishonoursValid(lender, creditScore, metricsMap)) {
            extendedLenderInfo.setAreDishonoursValid(VALID);
        }
        else {
            isValid = false;
            extendedLenderInfo.setAreDishonoursValid(INVALID);
        }

        /* PAY DAY LOANS */
        if (lenderUtil.arePayDayLoansValid(lender, metricsMap)) {
            extendedLenderInfo.setArePayDayLoansValid(VALID);
        }
        else {
            isValid = false;
            extendedLenderInfo.setArePayDayLoansValid(INVALID);
        }

        /* GAMBLING */
        if (lenderUtil.isGamblingAmountValid(lender, metricsMap)) {
            extendedLenderInfo.setIsGamblingAmountValid(VALID);
        }
        else {
            isValid = false;
            extendedLenderInfo.setIsGamblingAmountValid(INVALID);
        }

        return isValid;
    }

}
