package ConsumerFinancing.model.finances.personal;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Experience implements Serializable {

    @NotNull
    private Integer fullTime;

    @NotNull
    private Integer partTime;

    @NotNull
    private Integer selfEmployed;

    @NotNull
    private Integer casual;

    @NotNull
    private Integer contract;

    @NotNull
    private Integer current;

}
