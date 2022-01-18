package ConsumerFinancing.equifax.controller;

import ConsumerFinancing.equifax.models.model.Response;
import ConsumerFinancing.equifax.service.EquifaxService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/equifax")
public class EquifaxController {

    private final EquifaxService equifaxService;

    public EquifaxController(EquifaxService equifaxService) {
        this.equifaxService = equifaxService;
    }

    @GetMapping
    public Response getEquifaxResponse(
            @RequestParam String hashKey,
            @RequestParam String key) {
        return equifaxService.getEquifaxResponse(hashKey, key);
    }

}
