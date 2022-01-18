package ConsumerFinancing.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
public class UploadUtil {

    public Supplier<Stream<Row>> getRowStreamSupplier(MultipartFile file, Integer sheetNumber)
            throws IOException {
        Path tempDir = Files.createTempDirectory("");

        File tempFile = tempDir.resolve(Objects.requireNonNull(file.getOriginalFilename())).toFile();

        file.transferTo(tempFile);

        Workbook workbook = WorkbookFactory.create(tempFile);

        Sheet sheet = workbook.getSheetAt(sheetNumber);
        return () -> getStream(sheet);
    }

    public <T> Stream<T> getStream(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public Row getHeaderRow(Supplier<Stream<Row>> rowStreamSupplier) {
        return rowStreamSupplier.get().findFirst().get();
    }

    public List<Row> getRows(Supplier<Stream<Row>> rowStreamSupplier) {
        return rowStreamSupplier.get().skip(1).collect(Collectors.toList());
    }

    public void printHeaderRow(Supplier<Stream<Row>> rowStreamSupplier) {
        Row headerRow = getHeaderRow(rowStreamSupplier);

        log.info("Header Row is {}", headerRow.getCell(0).getStringCellValue());

        List<String> headerCells = getStream(headerRow)
                .map(Cell::getStringCellValue)
                .map(String::valueOf)
                .filter(header -> !header.isBlank())
                .collect(Collectors.toList());

        log.info("Header Cells are: {}", headerCells);
    }

}
