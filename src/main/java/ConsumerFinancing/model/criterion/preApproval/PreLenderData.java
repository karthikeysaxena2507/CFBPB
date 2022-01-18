package ConsumerFinancing.model.criterion.preApproval;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class PreLenderData implements Serializable {

    @NotBlank
    private String redisKey;

    @NotNull
    private List<PreLenderInfo> preLenderInfoList;

}
