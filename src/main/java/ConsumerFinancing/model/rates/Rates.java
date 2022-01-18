package ConsumerFinancing.model.rates;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Rates implements Serializable {

    @NotNull
    private Integer hemMonthlyExpenses;

    @NotNull
    private Integer userMonthlyExpenses;

    @NotBlank
    private String repaymentFrequency;

}
