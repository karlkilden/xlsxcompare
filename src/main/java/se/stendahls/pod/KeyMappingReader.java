package se.stendahls.pod;

import org.apache.poi.ss.usermodel.Workbook;

public class KeyMappingReader {

    public Workbook read(StartupConfig startupConfig) {


        ExcelWorkbookReader reader = new ExcelWorkbookReader();
        return reader.read(startupConfig.getKeyMappingExcel());

    }
}
