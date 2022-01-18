package ConsumerFinancing.service;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.entity.Income;
import ConsumerFinancing.repository.IncomeRepository;
import ConsumerFinancing.util.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Slf4j
@Service
public class IncomeService extends AppConfig {

    private final IncomeRepository incomeRepository;
    private final UploadUtil uploadUtil;

    public IncomeService(
            IncomeRepository incomeRepository,
            UploadUtil uploadUtil) {
        this.incomeRepository = incomeRepository;
        this.uploadUtil = uploadUtil;
    }

    public List<Income> uploadIncomes(MultipartFile file, Integer sheetNumber) throws IOException {

        Supplier<Stream<Row>> rowStreamSupplier = uploadUtil.getRowStreamSupplier(file, sheetNumber);

        List<Row> rows = uploadUtil.getRows(rowStreamSupplier);

        List<Income> incomes = new ArrayList<>();

        for (Row row: rows) {
            Income income = new Income();
            income.setRegion(row.getCell(0).getStringCellValue());
            income.setRelationshipStatus(row.getCell(1).getStringCellValue());
            income.setDependentsCount(row.getCell(2).toString());
            income.setMinIncome((int) row.getCell(3).getNumericCellValue());
            income.setMaxIncome((int) row.getCell(4).getNumericCellValue());
            income.setMonthlyIncome((int) row.getCell(5).getNumericCellValue());
            incomes.add(income);
        }

        return incomeRepository.saveAll(incomes);
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

}
