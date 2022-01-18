package ConsumerFinancing.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Document("LenderFees")
public class LenderFee {

    @NotBlank
    private String lenderName;

    @NotNull
    private Integer establishmentFee;

    @NotNull
    private Integer brokerageFee;

    @NotNull
    private Integer minLoanAmount;

    @NotNull
    private Integer maxLoanAmount;

}
