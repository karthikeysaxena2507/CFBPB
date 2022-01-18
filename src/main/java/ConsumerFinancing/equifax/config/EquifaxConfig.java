package ConsumerFinancing.equifax.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "equifax")
public class EquifaxConfig {

    private String username;
    private String password;
    private String enquiryUri;
    private String toHeader;
    private String actionHeader;
    private String headerNamespace;
    private String securityNamespace;

}
