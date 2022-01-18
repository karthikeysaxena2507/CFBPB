package ConsumerFinancing.model.finances;

import ConsumerFinancing.model.finances.assets.Assets;
import ConsumerFinancing.model.finances.expenses.Expenses;
import ConsumerFinancing.model.finances.liabilities.Liabilities;
import ConsumerFinancing.model.finances.personal.PersonalDetails;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Finance implements Serializable {

    @NotNull
    @Valid
    private PersonalDetails personalDetails;

    @NotNull
    @Valid
    private Expenses expenses;

    @NotNull
    @Valid
    private Assets assets;

    @NotNull
    @Valid
    private Liabilities liabilities;

}
