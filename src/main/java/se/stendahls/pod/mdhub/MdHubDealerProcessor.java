package se.stendahls.pod.mdhub;

import org.apache.poi.ss.usermodel.*;
import se.stendahls.pod.Dealer;
import se.stendahls.pod.DealerMapping;

import java.util.HashMap;
import java.util.Map;

public class MdHubDealerProcessor {
    DealerMapping dl = new DealerMapping();

    public DealerMapping process(Workbook workbook) {

        for (Sheet sheet : workbook) {
            mapData(sheet);
        }
        return dl;
    }

    private void mapData(Sheet sheet) {
        Map<Integer, String> columnIndex = new HashMap<>();

        boolean isDist = sheet.getSheetName().equals("Distribution");

        for (Row row : sheet) {

            if (row.getRowNum() == 0) {
                continue;

            }

            Dealer dealer = lookupDealer(row.getCell(isDist ? 28 : 1));
            for (Cell cell : row) {
                if (isDist && cell.getColumnIndex() == 27) {
                    dl.addByName(cell.getStringCellValue(), dealer);
                }

                    if (row.getRowNum() == 1) {
                    columnIndex.put(cell.getColumnIndex(), sheet.getSheetName() + "_" + cell.getStringCellValue());
                } else {
                    if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                        dealer.addFieldValue(columnIndex.get(cell.getColumnIndex()), String.valueOf(cell.getNumericCellValue()));

                    } else {
                        dealer.addFieldValue(columnIndex.get(cell.getColumnIndex()), cell.getStringCellValue());
                    }
                }
            }
        }


    }

    private Dealer lookupDealer(Cell cell) {
        return dl.getOrCreateMdHubDealer(cell.getStringCellValue());
    }
}
