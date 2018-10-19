package se.stendahls.pod.mdhub;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import se.stendahls.pod.Dealer;
import se.stendahls.pod.DealerLocatorFields;
import se.stendahls.pod.DealerMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MdHubDealerProcessor {

    private static final Set<String> addressRelated = Sets.newHashSet(DealerLocatorFields.MdHub.STREET_ADDRESS,
            DealerLocatorFields.MdHub.STREET_ADDRESS2, DealerLocatorFields.MdHub.STREET_ADDRESS3,
            DealerLocatorFields.MdHub.POSTAL_CODE, DealerLocatorFields.MdHub.CITY, DealerLocatorFields.MdHub.STATE, DealerLocatorFields.MdHub.FAX_NUMBER);
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

        boolean sheetUsed = false;
        for(String val:DealerLocatorFields.MdHub.FIELDS.values()) {
            if(val.startsWith(sheet.getSheetName())){
                         sheetUsed = true;
                         break;
            }


        }

        if(!sheetUsed)
            return;

        for (Row row : sheet) {

            if (row.getRowNum() == 0) {
                continue;

            }


            Dealer dealer = lookupDealer(row.getCell(isDist ? 28 : 1));
            if (dealer == null) {
                continue;
            }
            boolean isWalkToAddress = true;


            if (sheet.getSheetName().equals("Address")) {
                if (row.getRowNum() != 1 && row.getCell(2) != null && !StringUtils.equals("Main - Physical", row.getCell(2).getStringCellValue())) {
                    isWalkToAddress = false;
                    continue;
                }
            }
            for (Cell cell : row) {
                if (isDist && cell.getColumnIndex() == 27) {
                    dl.addByName(cell.getStringCellValue(), dealer);
                }

                if (row.getRowNum() == 1) {
                    columnIndex.put(cell.getColumnIndex(), sheet.getSheetName() + "_" + cell.getStringCellValue());
                } else {
                    if (isNotWrongAddress(isWalkToAddress, columnIndex.get(cell.getColumnIndex()))) {

                        if (cell.getCellTypeEnum() == CellType.NUMERIC) {


                            dealer.addFieldValue(columnIndex.get(cell.getColumnIndex()), String.valueOf(cell.getNumericCellValue()));

                        } else {
                            dealer.addFieldValue(columnIndex.get(cell.getColumnIndex()), cell.getStringCellValue());
                        }
                    }
                }
            }
        }


    }

    private boolean isNotWrongAddress(boolean isWalkToAddress, String s) {
        return isWalkToAddress ||!addressRelated.contains(s);

    }

    private Dealer lookupDealer(Cell cell) {
        if (cell == null) {
            return null;
        }
        if (StringUtils.isNotEmpty(cell.getStringCellValue())) {
            return dl.getOrCreateMdHubDealer(cell.getStringCellValue());
        }
        return null;
    }
}
