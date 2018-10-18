package se.stendahls.pod.mdhub;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import se.stendahls.pod.Dealer;
import se.stendahls.pod.DealerMapping;
import se.stendahls.pod.ExcelWorkbookReader;
import se.stendahls.pod.StartupStepResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MdHubDealerReader {

    ExcelWorkbookReader reader = new ExcelWorkbookReader();

    public Workbook read(StartupStepResult startupResult) {
        return reader.read(startupResult.getConfig().getMdHubExcel());
    }

}
