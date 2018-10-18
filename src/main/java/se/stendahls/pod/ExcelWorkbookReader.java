package se.stendahls.pod;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelWorkbookReader {

    public Workbook read(String filename) {

        FileInputStream excelFile = null;
        try {
            excelFile = new FileInputStream(new File(filename));
            if (filename.endsWith("xlsx"))
            return  new XSSFWorkbook(excelFile);

            else
                return new HSSFWorkbook(excelFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
