package ConsumerFinancing.model.finances.assets;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Assets implements Serializable {

    @NotNull
    private Integer savings;

    @NotNull
    private Integer homeContents;

    @NotNull
    private Integer existingVehicles;

    @NotNull
    private Integer investments;

    @NotNull
    private Integer otherAssets;

    @NotNull
    private Integer totalAssets;

}
