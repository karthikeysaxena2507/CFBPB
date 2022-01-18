package ConsumerFinancing.model.finances.expenses;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class MortgageExpense implements Serializable {

    @NotNull
    private Integer expense;

    @NotBlank
    private String frequency;

    @Min(0)
    @Max(100)
    @NotNull
    private Integer share;

}
