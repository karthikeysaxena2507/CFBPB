package ConsumerFinancing.model.finances.expenses;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Utility implements Serializable {

    @NotNull
    private Integer expense;

    @NotBlank
    private String frequency;

}
