package se.stendahls.pod;

import org.apache.poi.ss.usermodel.*;

import java.util.HashMap;
import java.util.Map;

public class KeyMappingProcessor {
    PodKeyMapping mapping = new PodKeyMapping();

    public PodKeyMapping process(Workbook workbook) {

            mapData(workbook.getSheetAt(0));

        return mapping;
    }

    private void mapData(Sheet sheet) {
        Map<Integer, String> columnIndex = new HashMap<>();

        for (Row row : sheet) {
            if (row.getRowNum() < 2) {
                continue;
            }

            String partyId = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            String guid = row.getCell(4,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

            mapping.add(partyId, guid);
        }


    }

}

