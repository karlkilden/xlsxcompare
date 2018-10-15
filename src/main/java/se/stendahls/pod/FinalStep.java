package se.stendahls.pod;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import se.stendahls.pod.idm.IdmStepResult;
import se.stendahls.pod.mdhub.MdHubStepResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class FinalStep {
    CellStyle rowStyle;


    private static String[] COLUMNS = {"Name IDM", "Name Md Hub", "Exists in IDM", "Exists in Md Hub", "IDM Region", "Md Hub Region", "IDM GUID", "Md Hub partyID", "IDM show in DL", "Md Hub show in DL", "Field", "IDM Value", "MdHub value"};

    public void read(StartupStepResult startupResult, IdmStepResult idmStepResult, MdHubStepResult mdHubStepResult) {

        Workbook workbook = new XSSFWorkbook();
        rowStyle = workbook.createCellStyle();
        rowStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        rowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CreationHelper createHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Dealer Locator");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < COLUMNS.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(COLUMNS[i]);
            cell.setCellStyle(headerCellStyle);
        }


        // Create Other rows and cells with employees data
        int rowNum = 1;

        int dlCount = 0;
        for (Dealer idmDealer : idmStepResult.getDealerMapping().getDealers()) {

            String idmName = idmDealer.getField(DealerLocatorFields.Idm.DISPLAY_NAME);
            Dealer mdHubDealer = mdHubStepResult.getDealerMapping().byName(idmName);
            if (mdHubDealer == null) {
                mdHubDealer = new Dealer();
            }
            int n = 0;
            for (String s : DealerLocatorFields.Neutral.FIELDS) {

                String idmCurrentValue = idmDealer.getField(DealerLocatorFields.Idm.FIELDS.get(DealerLocatorFields.Neutral.FIELDS[n]));
                String mdHubCurrentValue = mdHubDealer.getField(DealerLocatorFields.MdHub.FIELDS.get(DealerLocatorFields.Neutral.FIELDS[n]));
                if (s.equals(DealerLocatorFields.Neutral.COUNTRY) && StringUtils.isNotEmpty(mdHubCurrentValue)) {
                    mdHubCurrentValue = new Locale("", mdHubCurrentValue).getDisplayCountry(Locale.US);
                }

                if (s.equals(DealerLocatorFields.Neutral.REGION) && StringUtils.isNotEmpty(mdHubCurrentValue)) {
                    mdHubCurrentValue = getParsedMdHubField(mdHubCurrentValue);
                }

                if (s.equals(DealerLocatorFields.Neutral.STREET_ADDRESS2) && StringUtils.isNotEmpty(mdHubCurrentValue)) {
                    mdHubCurrentValue = mdHubCurrentValue + " " + mdHubDealer.getField(DealerLocatorFields.MdHub.STREET_ADDRESS3);
                }

                if (!StringUtils.equals(idmCurrentValue, mdHubCurrentValue)) {

                    rowNum = writeRow(workbook, sheet, rowNum, dlCount, idmDealer, mdHubDealer, s, idmCurrentValue, mdHubCurrentValue);
                }
                n++;

            }
            dlCount++;
        }
        // Resize all columns to fit the content size
        for (int i = 0; i < COLUMNS.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("poi-generated-file.xlsx");
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private int writeRow(Workbook workbook, Sheet sheet, int rowNum, int dlCount, Dealer idmDealer, Dealer mdHubDealer, String s, String idmCurrentValue, String mdHubCurrentValue) {
        Row row = sheet.createRow(rowNum++);

        createCell(row, 0, idmDealer.getField(DealerLocatorFields.Idm.DISPLAY_NAME), dlCount, workbook);


        createCell(row, 1,
                mdHubDealer.getField(DealerLocatorFields.MdHub.DISPLAY_NAME), dlCount, workbook);

        createCell(row, 2, idmDealer == null ? "N" : "Y", dlCount, workbook);

        createCell(row, 3, mdHubDealer == null ? "N" : "Y", dlCount, workbook);

        createCell(row, 4, idmDealer.getField(DealerLocatorFields.Idm.REGION), dlCount, workbook);
        createCell(row, 5, getParsedMdHubField(mdHubDealer.getField(DealerLocatorFields.MdHub.REGION)), dlCount, workbook);
        createCell(row, 6, idmDealer.getField(DealerLocatorFields.Idm.ID), dlCount, workbook);
        createCell(row, 7, mdHubDealer.getField(DealerLocatorFields.MdHub.ID), dlCount, workbook);
        createCell(row, 8, idmDealer.getField(DealerLocatorFields.Idm.SHOW_IN_DL), dlCount, workbook);
        createCell(row, 9, mdHubDealer.getField(DealerLocatorFields.MdHub.SHOW_IN_DL), dlCount, workbook);

        createCell(row, 10, s, dlCount, workbook);
        createCell(row, 11, idmCurrentValue, dlCount, workbook);


        createCell(row, 12, mdHubCurrentValue, dlCount, workbook);
        return rowNum;
    }

    private String getParsedMdHubField(String mdHubField) {
        if (StringUtils.isNotEmpty(mdHubField)) {
            return mdHubField.replace("Region ", "");
        }
        return mdHubField;
    }

    private void createCell(Row row, int index, String value, int dlCount, Workbook workbook) {
        Cell cell = row.createCell(index);
        cell.setCellValue(value);

        if (dlCount % 2 != 0) {
            cell.setCellStyle(rowStyle);
        }

    }


}
