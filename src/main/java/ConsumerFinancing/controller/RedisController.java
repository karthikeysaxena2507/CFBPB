package ConsumerFinancing.controller;

import ConsumerFinancing.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping
    public Map<String, Object> showAllKeyValues(
            @RequestParam String hashKey) {

        return redisService.getAllKeyValues(hashKey);
    }

    @GetMapping("/key")
    public Object showKeyValue(@RequestParam String hashKey, @RequestParam String key) {
        return redisService.getKeyValue(hashKey, key);
    }

    @GetMapping("/keys")
    public Set<String> getAllKeys(@RequestParam String hashKey) {
        return redisService.getAllKeys(hashKey);
    }

    @GetMapping("/check")
    public boolean checkKey(
            @RequestParam String hashKey,
            @RequestParam String key) {
        return redisService.contains(hashKey, key);
    }

    @PostMapping
    public void addKeyValue(
            @RequestParam String hashKey,
            @RequestParam String key,
            @RequestBody Object value) {

        redisService.addKeyValue(hashKey, key, value);
    }

    @DeleteMapping
    public Long deleteKey(
            @RequestParam String hashKey,
            @RequestParam String key) {
        return redisService.deleteKey(hashKey, key);
    }

    @DeleteMapping("/keys")
    public void deleteAll(@RequestParam String hashKey) {
        redisService.deleteAllKeys(hashKey);
    }
}
