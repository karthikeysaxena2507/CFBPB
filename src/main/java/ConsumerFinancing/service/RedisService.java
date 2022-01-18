package ConsumerFinancing.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {

    private final HashOperations hashOperations;
    private final RedisTemplate redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public String addKeyValue(String hashKey, String key, Object value) {
        log.info("hashKey is: {}", hashKey);
        log.info("Key is: {}", key);
        log.info("Value is: {}", value);
        hashOperations.put(hashKey, key, value);
        redisTemplate.expire(hashKey, 60, TimeUnit.MINUTES);
        return key;
    }

    public Long deleteKey(String hashKey, String key) {
        return hashOperations.delete(hashKey, key);
    }

    public Map<String, Object> getAllKeyValues(String hashKey) {
        return hashOperations.entries(hashKey);
    }

    public Object getKeyValue(String hashKey, String key) {
        return hashOperations.get(hashKey, key);
    }

    public void deleteAllKeys(String hashKey) {
        Set<String> keys = hashOperations.keys(hashKey);
        for (String key: keys) {
            deleteKey(hashKey, key);
        }
    }

    public Set<String> getAllKeys(String hashKey) {
        return hashOperations.keys(hashKey);
    }

    public boolean contains(String hashKey, String key) {
        return hashOperations.hasKey(hashKey, key);
    }

}
