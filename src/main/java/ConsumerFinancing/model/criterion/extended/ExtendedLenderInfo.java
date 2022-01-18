package ConsumerFinancing.model.criterion.extended;

import lombok.Data;
import java.io.Serializable;

@Data
public class ExtendedLenderInfo implements Serializable {

    /** LENDER INFO **/
    private String lenderName; /* LENDER NAME */
    private Boolean isLenderValid; /* LENDER VALIDITY */
    private Double interestRate; /* INTEREST RATE */
    private Double nsrValue; /* NSR VALUE */

    /** SCORECARD **/
    private String isServiceabilityValid; /* NET SERVICEABILITY RATIO */
    private String isUserServiceabilityValid; /* USER SERVICEABILITY RATIO */
    private String isAnnualIncomeValid; /* ANNUAL INCOME */
    private String arePayDayLoansValid; /* PAY DAY LOANS */
    private String areDishonoursValid; /* DISHONOURS */
    private String isGamblingAmountValid; /* GAMBLING AMOUNT */
    private String isEmploymentTenureValid; /* EMPLOYMENT TENURE */

    /** KNOCKOUTS **/
    private String isDrivingLicenseValid; /* DRIVING LICENSE */

}
