package ConsumerFinancing.service;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.model.finances.Finance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FinanceService extends AppConfig {

    private final RedisService redisService;

    public FinanceService(RedisService redisService) {
        this.redisService = redisService;
    }

    public String addFinanceToRedis(String hashKey, String key, Object value) {
        log.info("Finance Added to Redis");
        key = key + FINANCE_KEY;
        return redisService.addKeyValue(hashKey, key, value);
    }

    public Finance getFinanceFromRedis(String hashKey, String key) {
        key = key + FINANCE_KEY;
        return (Finance) redisService.getKeyValue(hashKey, key);
    }

}
