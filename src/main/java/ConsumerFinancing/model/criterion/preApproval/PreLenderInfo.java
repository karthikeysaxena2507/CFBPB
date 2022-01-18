package ConsumerFinancing.model.criterion.preApproval;

import lombok.Data;

import java.io.Serializable;

@Data
public class PreLenderInfo implements Serializable {

    /** LENDER INFO **/
    private String lenderName; /* LENDER NAME */
    private Double interestRate; /* INTEREST RATE */
    private Double comparisonRate; /* COMPARISON RATE */
    private Integer loanRepayment; /* LOAN REPAYMENT */
    private Boolean isLenderValid; /* LENDER VALIDITY */

    /** SCORECARD **/
    private String isCreditScoreValid; /* CREDIT SCORE **/
    private String isAdverseFileValid; /* ADVERSE FILE */
    private String isCreditFileAgeValid; /* CREDIT FILE AGE */
    private String isMaxRhiMostRecentValid; /* MAX RHI MOST RECENT */
    private String isMaxRhi3monthsValid; /* MAX RHI 3 MONTHS */
    private String isMaxRhi12monthsValid; /* MAX RHI 12 MONTHS */
    private String isMaxRhi24monthsValid; /* MAX RHI 24 MONTHS */
    private String isInsolvencyValid; /* INSOLVENCY */
    private String isFinancialDFValid; /* FINANCIAL DF */
    private String isNonFinancialDFValid; /* NON FINANCIAL DF */
    private String isOtherCourtActionsValid; /* OTHER COURT ACTIONS */
    private String isResidenceStable; /* RESIDENCE STABILITY */

    /** KNOCKOUTS **/
    private String isAgeValid; /* AGE */
    private String isEmploymentStatusValid; /* EMPLOYMENT STATUS */
    private String isResidencyStatusValid; /* RESIDENCE STATUS */

    /** LOAN TERMS **/
    private String isLoanAmountValid; /* LOAN AMOUNT */
    private String isLoanTermValid; /* LOAN TERM */
    private String isRepaymentFrequencyValid; /* REPAYMENT FREQUENCY */
    private String isBalloonValid; /* BALLOON */
    private String isVehicleAgeValid; /* VEHICLE AGE */
    private String isOdometerReadingValid; /* ODOMETER READING */
    private String isLvrValid; /* LOAN TO VALUE RATIO */

}
