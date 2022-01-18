package ConsumerFinancing.equifax.service;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.entity.Lender;
import ConsumerFinancing.equifax.config.EquifaxClient;
import ConsumerFinancing.equifax.models.model.*;
import ConsumerFinancing.equifax.models.model.RequestType.EnquiryData;
import ConsumerFinancing.equifax.models.model.RequestType.EnquiryHeader;
import ConsumerFinancing.equifax.models.model.RequestType.EnquiryHeader.RequestedScores;
import ConsumerFinancing.equifax.models.model.IndividualInputType.Addresses;
import ConsumerFinancing.model.criterion.preApproval.PreLenderInfo;
import ConsumerFinancing.model.customers.Customer;
import ConsumerFinancing.service.CustomerService;
import ConsumerFinancing.util.LenderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EquifaxService extends AppConfig {

    private final CustomerService customerService;
    private final EquifaxClient equifaxClient;
    private final LenderUtil lenderUtil;

    public EquifaxService(
            CustomerService customerService,
            EquifaxClient equifaxClient,
            LenderUtil lenderUtil) {

        this.customerService = customerService;
        this.equifaxClient = equifaxClient;
        this.lenderUtil = lenderUtil;
    }

    public Response getEquifaxResponse(String hashKey, String key) {
        Customer customer = customerService.getCustomerFromRedis(hashKey, key);
        log.info("Customer is {}", customer);
        return equifaxClient.getResponse(getRequest(customer));
    }

    public boolean areEquifaxFieldsValid(
            Response response, PreLenderInfo lender, Customer customer) {

        boolean isValid = true;
        List<DataBlockType> data = response
                .getProductData()
                .getSummaryData()
                .getDataBlock();

        if (data.isEmpty()) return true;
        List<CharacteristicType> characteristics = data.get(0).getCharacteristic();

        Map<String, CharacteristicType> charMap = new HashMap<>();
        for (CharacteristicType type: characteristics) {
            charMap.put(type.getId(), type);
        }
        log.info("Char Map is {}", charMap);

        String lenderName = lender.getLenderName();

        /* ADVERSE FILE */
        String status = lenderUtil.isAdverseFileValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsAdverseFileValid(INVALID);
        }
        else {
            lender.setIsAdverseFileValid(status);
        }

        /* CREDIT FILE AGE*/
        status = lenderUtil.isCreditFileAgeValid(charMap, lenderName, customer);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsCreditFileAgeValid(INVALID);
        }
        else {
            lender.setIsCreditFileAgeValid(status);
        }

        /* MAX RHI MOST RECENT */
        status = lenderUtil.isMaxRhiMostRecentValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsMaxRhiMostRecentValid(INVALID);
        }
        else {
            lender.setIsMaxRhiMostRecentValid(status);
        }

        /* MAX RHI 3 MONTHS */
        status = lenderUtil.isMaxRhi3monthsValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsMaxRhi3monthsValid(INVALID);
        }
        else {
            lender.setIsMaxRhi3monthsValid(status);
        }

        /* MAX RHI 12 MONTHS */
        status = lenderUtil.isMaxRhi12monthsValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsMaxRhi12monthsValid(INVALID);
        }
        else {
            lender.setIsMaxRhi12monthsValid(status);
        }

        /* MAX RHI 24 MONTHS */
        status = lenderUtil.isMaxRhi24monthsValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsMaxRhi24monthsValid(INVALID);
        }
        else {
            lender.setIsMaxRhi24monthsValid(status);
        }

        /* INSOLVENCY */
        status = lenderUtil.isInsolvencyValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsInsolvencyValid(INVALID);
        }
        else {
            lender.setIsInsolvencyValid(status);
        }

        /* FINANCIAL DF */
        status = lenderUtil.isFinancialDFValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsFinancialDFValid(INVALID);
        }
        else {
            lender.setIsFinancialDFValid(status);
        }

        /* NON FINANCIAL DF */
        status = lenderUtil.isNonFinancialDFValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsNonFinancialDFValid(INVALID);
        }
        else {
            lender.setIsNonFinancialDFValid(status);
        }

        /* OTHER COURT ACTIONS */
        status = lenderUtil.isOtherCourtActionsValid(charMap, lenderName);
        if (status.equals(INVALID)) {
            isValid = false;
            lender.setIsOtherCourtActionsValid(INVALID);
        }
        else {
            lender.setIsOtherCourtActionsValid(status);
        }

        return isValid;
    }

    public List<ScoreType> getCreditScore(ResponseType response) {
        return response
                .getProductData()
                .getScoreData()
                .getScore();
    }

    private RequestType getRequest(Customer customer) {
        RequestType request = new RequestType();

        /* SETTING ENQUIRY HEADERS */
        EnquiryHeader enquiryHeader = new EnquiryHeader();
        enquiryHeader.setPermissionTypeCode("X");
        enquiryHeader.setProductDataLevelCode("C");
        List<String> scores = List.of("VSA_2.0_X_CR");
        RequestedScores requestedScores = new RequestedScores();
        requestedScores.setScorecardId(scores);
        enquiryHeader.setRequestedScores(requestedScores);

        /* SETTING ENQUIRY DATA */
        EnquiryData enquiryData = new EnquiryData();
        enquiryData.setEnquiry(new EnquiryType());

        IndividualNameInputType currentName = new IndividualNameInputType();
        currentName.setFamilyName(customer.getPersonal().getLastName());
        currentName.setFirstGivenName(customer.getPersonal().getFirstName());

        List<AddressInputType> addressList = new ArrayList<>();
        AddressInputType address = new AddressInputType();
        address.setStreetNumber(customer.getAddress().getStreetNumber().toString());
        address.setStreetName(customer.getAddress().getStreetName());
        address.setStreetType(customer.getAddress().getStreetType());
        address.setType(CurrentPreviousType.C);
        address.setSuburb(customer.getAddress().getSuburb());
        address.setState(new StateType(AustralianStateType.fromValue(
                customer.getAddress().getState()
        )));
        address.setPostcode(customer.getAddress().getPostCode());
        address.setCountryCode(new CountryType(CountryCodeEnumType.AUS));
        addressList.add(address);
        Addresses addresses = new Addresses();
        addresses.setAddress(addressList);

        IndividualInputType individual = new IndividualInputType();
        individual.setCurrentName(currentName);
        individual.setAddresses(addresses);
        individual.setGenderCode(GenderCodeType.fromValue(getGenderCode(
                customer.getPersonal().getGender()
        )));

        enquiryData.setIndividual(individual);

        request.setEnquiryHeader(enquiryHeader);
        request.setEnquiryData(enquiryData);

        return request;
    }

    private String getGenderCode(String gender) {
        switch (gender) {
            case "Male":
                return "M";
            case "Female":
                return "F";
            default:
                return "U";
        }
    }

}
