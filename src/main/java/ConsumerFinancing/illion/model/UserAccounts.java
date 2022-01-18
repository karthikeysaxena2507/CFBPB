package ConsumerFinancing.illion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccounts implements Serializable {

    Map<String, List<Integer>> accounts;

    private String user_token;

}
