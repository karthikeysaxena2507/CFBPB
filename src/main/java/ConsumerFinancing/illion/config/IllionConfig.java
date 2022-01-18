package ConsumerFinancing.illion.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "illion")
public class IllionConfig {

    private String apiKey;
    private String loginUri;
    private String statementsUri;
    private String referralCode;
    private String outputVersion;

    public static final String VALID = "Valid";
    public static final String INVALID = "Invalid";

    public HttpHeaders getBasicHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", apiKey);
        headers.set("REFERRAL-CODE", referralCode);
        headers.set("X-OUTPUT-VERSION", outputVersion);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        return headers;
    }

}
