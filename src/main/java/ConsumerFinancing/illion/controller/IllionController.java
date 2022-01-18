package ConsumerFinancing.illion.controller;

import ConsumerFinancing.illion.model.User;
import ConsumerFinancing.illion.service.IllionService;
import ConsumerFinancing.model.criterion.extended.ExtendedLenderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/illion")
public class IllionController {

    private final IllionService illionService;

    public IllionController(IllionService illionService) {
        this.illionService = illionService;
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ExtendedLenderInfo> getUpdatedLenders(
            @RequestParam String hashKey,
            @RequestParam String key,
            @RequestBody User user) {
        return illionService.getUpdatedExtendedLenders(user, hashKey, key);
    }

}
