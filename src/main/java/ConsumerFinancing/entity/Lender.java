package ConsumerFinancing.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Document("Lenders")
public class Lender implements Serializable {

    @Id
    private String lenderName;

    @NotNull
    private Integer minAge;

    @NotNull
    private Integer maxAge;

    @NotNull
    private Integer minLoanAmount;

    @NotNull
    private Integer maxLoanAmount;

    @NotNull
    private Integer minAnnualIncome;

    @NotNull
    private List<Integer> allowedLoanTerms;

    @NotNull
    private List<String> repaymentFrequencies;

    @NotNull
    private List<String> residencyStatuses;

    @NotEmpty
    private Integer minCreditScore;

    @NotEmpty
    private Integer maxCreditScore;

}
