package ConsumerFinancing.model.customers;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Vehicle implements Serializable {

    @NotNull
    private Integer vehicleYear;

    @NotNull
    private Integer vehiclePrice;

    @NotNull
    private Integer deposit;

    @NotNull
    private Integer endOfLoanPayment;

    @NotNull
    private Boolean forBusinessPurpose;

    @NotNull
    private String repaymentFrequency;

    @NotNull
    private Integer loanTerm;

    @NotNull
    private Integer value;

}
