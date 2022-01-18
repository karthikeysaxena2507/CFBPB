package ConsumerFinancing.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppConfig {

    public static final List<String> SUBURBS = new ArrayList<>(Arrays.asList(
            "Sydney", "Melbourne", "Brisbane", "Adelaide", "Perth", "Hobart"
    ));

    public static final List<String> STATES = new ArrayList<>(Arrays.asList(
            "NSW", "VIC", "QLD", "SA", "WA", "TAS", "ACT", "NT"
    ));

    public static final List<String> HOME_OWNERS = List.of(
            "Renting But Own Property",
            "Owner without Mortgage",
            "Owner with Mortgage"
    );

    public static final String UNEMPLOYED = "Unemployed";
    public static final String HOME_OWNER = "Home Owner";
    public static final String NON_HOME_OWNER = "Non Home Owner";
    public static final String MARRIED = "Married";
    public static final String SINGLE = "Single";
    public static final String COUPLE = "Couple";
    public static final String ABOVE_4 = "count above 4";

    // REDIS KEYS INFO
    public static final String FINANCE_KEY = "FINANCE";
    public static final String CUSTOMER_KEY = "CUSTOMER";
    public static final String PRE_LENDER_KEY = "PRE_LENDER";
    public static final String EXTENDED_LENDER_KEY = "EXTENDED_LENDER";
    public static final String LENDER_KEY = "LENDER";
    public static final String RATES_KEY = "RATES";

    // FREQUENCY
    public static final String MONTHLY = "Monthly";
    public static final String WEEKLY = "Weekly";
    public static final String FORTNIGHTLY = "Fortnightly";
    public static final String ANNUALLY = "Annually";

    // VALIDITY STATUS
    public static final String VALID = "Valid";
    public static final String INVALID = "Invalid";
    public static final String NOT_DECIDED = "Not Decided";

    // LENDERS
    public static final String WISR = "Wisr";
    public static final String FIRSTMAC = "FirstMac";
    public static final String PLENTI = "Plenti";
    public static final String AUTOPAY = "AutoPay";

    // EMPLOYMENTS
    public static final String FULL_TIME = "Full Time";
    public static final String PART_TIME = "Part Time";
    public static final String CASUAL = "Casual";
    public static final String CONTRACT = "Contract";
    public static final String SELF_EMPLOYED = "Self Employed";

}
