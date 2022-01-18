package ConsumerFinancing.controller;

import ConsumerFinancing.entity.LenderFee;
import ConsumerFinancing.service.LenderFeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/lenderFees")
public class LenderFeeController {

    private final LenderFeeService lenderFeeService;

    public LenderFeeController(LenderFeeService lenderFeeService) {
        this.lenderFeeService = lenderFeeService;
    }

    @PostMapping
    public List<LenderFee> uploadLenderFees(
            @RequestBody MultipartFile file,
            @RequestParam Integer sheetNumber) throws IOException {
        return lenderFeeService.uploadLenderFees(file, sheetNumber);
    }

}
