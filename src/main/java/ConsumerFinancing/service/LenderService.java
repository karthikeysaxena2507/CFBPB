package ConsumerFinancing.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.entity.Income;
import ConsumerFinancing.entity.Lender;
import ConsumerFinancing.model.rates.Rates;
import ConsumerFinancing.model.finances.Finance;
import ConsumerFinancing.repository.IncomeRepository;
import ConsumerFinancing.util.FormulaeUtil;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ConsumerFinancing.repository.LenderRepository;
import ConsumerFinancing.util.UploadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LenderService extends AppConfig {

    private final LenderRepository lenderRepository;
    private final UploadUtil uploadUtil;
    private final RedisService redisService;

    public LenderService(
            LenderRepository lenderRepository,
            UploadUtil uploadUtil,
            RedisService redisService) {
        this.lenderRepository = lenderRepository;
        this.uploadUtil = uploadUtil;
        this.redisService = redisService;
    }

    public List<Lender> uploadLenders(MultipartFile file, Integer sheetNumber) throws IOException {

        Supplier<Stream<Row>> rowStreamSupplier = uploadUtil.getRowStreamSupplier(file, sheetNumber);

        List<Row> rows = uploadUtil.getRows(rowStreamSupplier);

        List<Lender> lenders = new ArrayList<>();

        for (Row row: rows) {
            Lender lender = new ConsumerFinancing.entity.Lender();
            lender.setLenderName(row.getCell(0).getStringCellValue());
            lender.setMinAge((int) row.getCell(1).getNumericCellValue());
            lender.setMaxAge((int) row.getCell(2).getNumericCellValue());
            lender.setMinLoanAmount((int) row.getCell(3).getNumericCellValue());
            lender.setMaxLoanAmount((int) row.getCell(4).getNumericCellValue());
            lender.setMinCreditScore((int) row.getCell(5).getNumericCellValue());
            lender.setMaxCreditScore((int) row.getCell(6).getNumericCellValue());
            lender.setAllowedLoanTerms(new ArrayList<>());
            lender.setResidencyStatuses(new ArrayList<>());
            lenders.add(lender);
        }

        log.info("count of Lenders is: {}", lenders.size());
        log.info("\n Lenders are: {}", lenders);
        return lenderRepository.saveAll(lenders);
    }

    public List<Lender> getLenders(String hashKey, String key) {
        if (redisService.contains(hashKey, key + LENDER_KEY)) {
            return getLendersFromRedis(hashKey, key);
        }
        List<Lender> lenders = lenderRepository.findAll();
        addLendersToRedis(hashKey, key, lenders);
        return lenders;
    }

    public List<Lender> getLendersFromRedis(String hashKey, String key) {
        key = key + LENDER_KEY;
        return (List<Lender>) redisService.getKeyValue(hashKey, key);
    }

    public void addLendersToRedis(String hashKey, String key, Object value) {
        key = key + LENDER_KEY;
        redisService.addKeyValue(hashKey, key, value);
    }

}
