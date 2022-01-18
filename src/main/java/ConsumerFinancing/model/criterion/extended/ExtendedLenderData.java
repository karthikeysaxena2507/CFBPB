package ConsumerFinancing.model.criterion.extended;

import ConsumerFinancing.model.rates.Rates;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ExtendedLenderData implements Serializable {

    @NotNull
    private Rates rates;

    @NotNull
    List<ExtendedLenderInfo> extendedLenderInfoList;

}
