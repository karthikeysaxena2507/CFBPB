package ConsumerFinancing.service;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.entity.Lender;
import ConsumerFinancing.entity.LenderFee;
import ConsumerFinancing.repository.LenderFeeRepository;
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

@Service
@Slf4j
public class LenderFeeService extends AppConfig {

    private final LenderFeeRepository lenderFeeRepository;
    private final UploadUtil uploadUtil;

    public LenderFeeService(
            LenderFeeRepository lenderFeeRepository,
            UploadUtil uploadUtil) {
        this.lenderFeeRepository = lenderFeeRepository;
        this.uploadUtil = uploadUtil;
    }

    public List<LenderFee> uploadLenderFees(
            MultipartFile file,
            Integer sheetNumber) throws IOException {

        Supplier<Stream<Row>> rowStreamSupplier = uploadUtil.getRowStreamSupplier(file, sheetNumber);

        List<Row> rows = uploadUtil.getRows(rowStreamSupplier);

        List<LenderFee> lenderFees = new ArrayList<>();

        for (Row row: rows) {
            LenderFee fee = new LenderFee();
            fee.setLenderName(row.getCell(0).getStringCellValue());
            fee.setEstablishmentFee((int) row.getCell(1).getNumericCellValue());
            fee.setBrokerageFee((int) row.getCell(2).getNumericCellValue());
            fee.setMinLoanAmount((int) row.getCell(3).getNumericCellValue());
            fee.setMaxLoanAmount((int) row.getCell(4).getNumericCellValue());
            lenderFees.add(fee);
        }

        log.info("count of Lender fees is: {}", lenderFees.size());
        log.info("\n Lender fees are: {}", lenderFees);

        return lenderFeeRepository.saveAll(lenderFees);
    }

    public Integer getLenderFees(Integer loanAmount, String lenderName) {
        log.info("Loan Amount is {}", loanAmount);
        log.info("Lender Name is {}", lenderName);
        List<LenderFee> fees = lenderFeeRepository.getTotalFees(loanAmount, lenderName);
        log.info("fees is {}", fees);
        return (fees.isEmpty()) ? 0 : fees.get(0).getEstablishmentFee()
                + fees.get(0).getBrokerageFee();
    }

}
