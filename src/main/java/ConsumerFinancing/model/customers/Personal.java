package ConsumerFinancing.model.customers;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Personal implements Serializable {

    @NotBlank
    private String firstName;

    @NotNull
    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String dateOfBirth;

    @NotBlank
    private String gender;

    @NotBlank
    private String residencyStatus;

    @NotBlank
    private String livingStatus;

    @NotBlank
    private String employmentStatus;

    @NotNull
    private Integer creditScore;

}
