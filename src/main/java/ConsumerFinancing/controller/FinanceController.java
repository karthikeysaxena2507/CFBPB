package ConsumerFinancing.controller;

import ConsumerFinancing.model.finances.Finance;
import ConsumerFinancing.service.FinanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/finances")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @PostMapping("/redis")
    public String addFinance(
            @RequestParam String hashKey,
            @RequestParam String key,
            @RequestBody Object value) {
        return financeService.addFinanceToRedis(hashKey, key, value);
    }

    @GetMapping("/redis")
    public Finance getFinance(
            @RequestParam String hashKey,
            @RequestParam String key) {
        return financeService.getFinanceFromRedis(hashKey, key);
    }

}
