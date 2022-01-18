package ConsumerFinancing.model.finances.liabilities;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Mortgage implements Serializable {

    @NotNull
    private Integer balance;

    @NotNull
    private Integer repayment;

    @NotBlank
    private String lenderName;

    @NotNull
    private Integer propertyValue;

}
