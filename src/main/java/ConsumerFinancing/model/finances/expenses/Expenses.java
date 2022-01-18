package ConsumerFinancing.model.finances.expenses;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Expenses implements Serializable {

    @Valid
    @NotNull
    private MortgageExpense mortgageExpense;

    @Valid
    @NotNull
    private FoodAndGroceries foodAndGroceries;

    @Valid
    @NotNull
    private HealthAndEducation healthAndEducation;

    @Valid
    @NotNull
    private Utility utility;

    @Valid
    @NotNull
    private Entertainment entertainment;

    @Valid
    @NotNull
    private OtherExpense otherExpense;

    @Valid
    @NotNull
    private Transport transport;

    @NotNull
    private Integer totalExpense;

}
