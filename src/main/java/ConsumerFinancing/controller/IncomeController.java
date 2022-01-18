package ConsumerFinancing.controller;

import ConsumerFinancing.entity.Income;
import ConsumerFinancing.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/incomes")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public List<Income> getIncomes() {
        return incomeService.getAllIncomes();
    }

    @PostMapping("/upload")
    public List<Income> addIncomeDataToDatabase(
            @RequestBody MultipartFile file,
            @RequestParam Integer sheetNumber) throws IOException {

        return incomeService.uploadIncomes(file, sheetNumber);
    }

}
