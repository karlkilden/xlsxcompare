package se.stendahls.pod.mdhub;

import org.apache.poi.ss.usermodel.Workbook;
import se.stendahls.pod.DealerMapping;

public class MdHubStepResult {
    private Workbook workbook;
    private DealerMapping dealerMapping;

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public Workbook getWorkbook() {

        return workbook;
    }

    public void setDealerMapping(DealerMapping dealerMapping) {
        this.dealerMapping = dealerMapping;
    }

    public DealerMapping getDealerMapping() {
        return dealerMapping;
    }
}
