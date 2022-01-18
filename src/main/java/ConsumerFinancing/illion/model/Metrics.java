package ConsumerFinancing.illion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metrics implements Serializable {

    private String id;
    private String name;
    private String type;
    private Object value;

}
