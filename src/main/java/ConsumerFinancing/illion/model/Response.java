package ConsumerFinancing.illion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {

    private List<Metrics> decisionMetrics;
    private String referral_code;
    private String user_token;
    private String submissionTime;

}
