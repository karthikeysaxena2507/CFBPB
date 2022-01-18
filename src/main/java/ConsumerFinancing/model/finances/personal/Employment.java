package ConsumerFinancing.model.finances.personal;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Employment implements Serializable {

    @NotBlank
    private String employer;

    @NotBlank
    private String occupation;

    @NotBlank
    private String employmentType;

    @NotNull
    private Integer employmentYears;

    @NotNull
    private Integer employmentMonths;

}
