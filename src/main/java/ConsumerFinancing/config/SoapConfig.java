package ConsumerFinancing.config;

import ConsumerFinancing.equifax.config.EquifaxClient;
import ConsumerFinancing.equifax.config.EquifaxConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("ConsumerFinancing.equifax.models.model");
        return marshaller;
    }

    @Bean
    public EquifaxClient soapClient(Jaxb2Marshaller marshaller, EquifaxConfig config) {
        EquifaxClient client = new EquifaxClient(marshaller, config);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
