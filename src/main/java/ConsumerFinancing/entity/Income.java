package ConsumerFinancing.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Document("Incomes")
public class Income implements Serializable {

    @Id
    private String id;

    @NotBlank
    private String region;

    @NotBlank
    private String relationshipStatus;

    @NotBlank
    private String dependentsCount;

    @NotNull
    private Integer minIncome;

    @NotNull
    private Integer maxIncome;

    @NotNull
    private Integer monthlyIncome;

}
