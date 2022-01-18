package ConsumerFinancing.model.finances.liabilities;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class Liabilities implements Serializable {

    @NotNull
    private List<CreditCard> creditCards;

    @NotNull
    private List<PersonalLoan> personalLoans;

    @NotNull
    private List<Mortgage> mortgages;

    @NotNull
    private List<VehicleLoan> vehicleLoans;

    @NotNull
    private List<OtherLiability> otherLiabilities;

    @NotNull
    private Integer buyNowPayLaterAccounts;

    @NotNull
    private Integer totalRepayments;

    @NotNull
    private Integer totalCreditCardBalance;

}
