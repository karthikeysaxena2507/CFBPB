package ConsumerFinancing.illion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credentials implements Serializable {

    @NotBlank
    private String institution;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
