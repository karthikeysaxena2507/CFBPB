package ConsumerFinancing.controller;

import ConsumerFinancing.entity.Lender;
import ConsumerFinancing.service.LenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/lenders")
public class LenderController {

    private final LenderService lenderService;

    public LenderController(LenderService lenderService) {
        this.lenderService = lenderService;
    }

    @PostMapping("/upload")
    public List<Lender> uploadLender(
            @RequestBody MultipartFile file,
            @RequestParam Integer sheetNumber) throws Exception {
        return lenderService.uploadLenders(file, sheetNumber);
    }

    @GetMapping
    public List<Lender> getLenders(
            @RequestParam String hashKey,
            @RequestParam String key) {
        return lenderService.getLenders(hashKey, key);
    }

    @GetMapping("/redis")
    public List<Lender> getLendersFromCache(
            @RequestParam String hashKey,
            @RequestParam String key) {
        return lenderService.getLendersFromRedis(hashKey, key);
    }

    @PostMapping("/redis")
    public void addLendersToCache(
            @RequestParam String hashKey,
            @RequestParam String key,
            @RequestBody Object value) {
        lenderService.addLendersToRedis(hashKey, key, value);
    }

}
