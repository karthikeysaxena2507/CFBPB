package ConsumerFinancing.model.finances.liabilities;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PersonalLoan implements Serializable {

    @NotNull
    private Integer balance;

    @NotNull
    private Integer repayment;

}
