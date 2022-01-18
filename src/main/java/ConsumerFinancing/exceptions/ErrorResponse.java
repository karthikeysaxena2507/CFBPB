package ConsumerFinancing.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String exceptionType;
    private String errorCausingField;
    private String errorCause;
    private int errorCode;

}