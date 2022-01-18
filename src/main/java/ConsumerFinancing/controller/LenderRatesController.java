package ConsumerFinancing.controller;

import ConsumerFinancing.entity.LenderRate;
import ConsumerFinancing.model.criterion.extended.ExtendedLenderInfo;
import ConsumerFinancing.model.customers.Customer;
import ConsumerFinancing.model.criterion.preApproval.PreLenderInfo;
import ConsumerFinancing.model.criterion.preApproval.PreLenderData;
import ConsumerFinancing.service.LenderRatesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/lenderRates")
public class LenderRatesController {

    private final LenderRatesService lenderRatesService;

    public LenderRatesController(LenderRatesService lenderRatesService) {
        this.lenderRatesService = lenderRatesService;
    }

    @PostMapping("/upload")
    public List<LenderRate> uploadLender(
            @RequestBody MultipartFile file,
            @RequestParam Integer sheetNumber) throws Exception {
        return lenderRatesService.uploadLenderRates(file, sheetNumber);
    }

    @PostMapping
    public PreLenderData getLenders(
            @RequestBody @Valid Customer customer,
            @RequestParam String hashKey,
            @RequestParam String key) {
        return lenderRatesService.getPreLenders(customer, hashKey, key);
    }

    @GetMapping("/redis")
    public List<PreLenderInfo> getPreLenderDataFromCache(
            @RequestParam String hashKey,
            @RequestParam String key) {

        return lenderRatesService.getPreLenderInfoListFromRedis(hashKey, key);
    }

    @PostMapping("/redis")
    public void addPreLenderDataToCache(
            @RequestParam String hashKey,
            @RequestParam String key,
            @RequestBody Object value) {

        lenderRatesService.addPreLenderInfoListToRedis(hashKey, key, value);
    }

    @GetMapping("/extended/redis")
    public List<ExtendedLenderInfo> getExtendedLenderDataFromCache(
            @RequestParam String hashKey,
            @RequestParam String key) {

        return lenderRatesService.getExtendedLenderInfoListFromRedis(hashKey, key);
    }

    @PostMapping("/extended/redis")
    public void addExtendedLenderDataToCache(
            @RequestParam String hashKey,
            @RequestParam String key,
            @RequestBody Object value) {

        lenderRatesService.addExtendedLenderInfoListToRedis(hashKey, key, value);
    }
}
