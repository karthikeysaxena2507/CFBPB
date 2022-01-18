package ConsumerFinancing.model.customers;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Customer implements Serializable {

    @NotNull
    @Valid
    private Address address;

    @NotNull
    @Valid
    private Personal personal;

    @NotNull
    @Valid
    private Vehicle vehicle;

}
