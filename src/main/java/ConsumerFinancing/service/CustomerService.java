package ConsumerFinancing.service;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.model.customers.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService extends AppConfig {

    private final RedisService redisService;

    public CustomerService(RedisService redisService) {
        this.redisService = redisService;
    }

    public String addCustomerToRedis(String hashKey, String key, Object value) {
        log.info("Customer Added to Redis");
        key = key + CUSTOMER_KEY;
        return redisService.addKeyValue(hashKey, key, value);
    }

    public Customer getCustomerFromRedis(String hashKey, String key) {
        key = key + CUSTOMER_KEY;
        return (Customer) redisService.getKeyValue(hashKey, key);
    }
}
