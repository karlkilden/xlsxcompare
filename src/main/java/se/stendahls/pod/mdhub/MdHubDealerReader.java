package se.stendahls.pod.mdhub;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import se.stendahls.pod.Dealer;
import se.stendahls.pod.DealerMapping;
import se.stendahls.pod.StartupStepResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MdHubDealerReader {
    private static final String FILE_NAME = "mdhub/MDHUB - Commercial Organization.XLS";


    DealerMapping dl = new DealerMapping();

    public Workbook read(StartupStepResult startupResult) {


        FileInputStream excelFile = null;
        try {
            excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new HSSFWorkbook(excelFile);

            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private Dealer lookupDealer(Cell cell) {
        return dl.getOrCreateMdHubDealer(cell.getStringCellValue());
    }
}
