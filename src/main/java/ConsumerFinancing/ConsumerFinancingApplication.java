package ConsumerFinancing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "ConsumerFinancing")
public class ConsumerFinancingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFinancingApplication.class, args);
    }

}
