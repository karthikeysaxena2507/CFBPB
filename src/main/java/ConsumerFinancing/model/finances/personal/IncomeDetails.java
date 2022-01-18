package ConsumerFinancing.model.finances.personal;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class IncomeDetails implements Serializable {

    @NotNull
    private Integer income;

    @NotBlank
    private String incomeFrequency;

    @NotBlank
    private String occupation;

    @NotBlank
    private String currentEmployer;

    @NotBlank
    private String currentEmploymentType;

    @NotNull
    private Integer currentEmploymentYears;

    @NotNull
    private Integer currentEmploymentMonths;

    @NotNull
    private Integer additionalIncomeSources;

}
