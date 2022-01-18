package ConsumerFinancing.model.finances.personal;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class PersonalDetails implements Serializable {

    @NotBlank
    private String relationshipStatus;

    @NotNull
    private Integer numberOfDependents;

    @NotBlank
    private String suburb;

    @NotBlank
    private String state;

    @NotNull
    @Valid
    private IncomeDetails incomeDetails;

    @NotNull
    @Valid
    private List<Employment> prevEmployments;

    @NotNull
    @Valid
    private Experience experience;

}
