package ConsumerFinancing.model.customers;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class Address implements Serializable {

    @NotNull
    private Integer unitNumber;

    @NotNull
    private Integer streetNumber;

    @NotBlank
    private String streetType;

    @NotBlank
    private String streetName;

    @NotBlank
    private String suburb;

    @NotBlank
    private String state;

    @NotBlank
    private String postCode;

    @Min(0)
    @Max(20)
    @NotNull
    private Integer yearsOfLiving;

    @Min(1)
    @Max(12)
    @NotNull
    private Integer monthsOfLiving;

}
