package ConsumerFinancing.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Document("LenderRates")
public class LenderRate implements Serializable {

    @Id
    private String id;

    @NotBlank
    private String lenderName;

    @NotBlank
    private String livingStatus;

    @NotEmpty
    private Double interestRate;

    @NotEmpty
    private Integer minCreditScore;

    @NotEmpty
    private Integer maxCreditScore;

    @Min(0)
    @Max(12)
    @NotEmpty
    private Integer assetAge;
}
