package ConsumerFinancing.controller;

import ConsumerFinancing.model.criterion.extended.ExtendedLenderData;
import ConsumerFinancing.model.finances.Finance;
import ConsumerFinancing.model.rates.Rates;
import ConsumerFinancing.service.RatesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/rates")
public class RatesController {

    private final RatesService ratesService;

    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @PostMapping
    public ExtendedLenderData getRates(
            @RequestBody @Valid Finance finance,
            @RequestParam String hashKey,
            @RequestParam String key) {
        return ratesService.getRates(finance, hashKey, key);
    }

    @GetMapping("/redis")
    public Rates getRatesFromRedis(
            @RequestParam String hashKey,
            @RequestParam String key) {
        return ratesService.getRatesFromRedis(hashKey, key);
    }

    @PostMapping("/redis")
    public void addRatesToRedis(
            @RequestParam String hashKey,
            @RequestParam String key,
            @RequestBody Object value) {
        ratesService.addRatesToRedis(hashKey, key, value);
    }

}
