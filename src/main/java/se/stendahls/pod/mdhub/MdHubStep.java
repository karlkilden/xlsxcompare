package se.stendahls.pod.mdhub;

import org.apache.poi.ss.usermodel.Workbook;
import se.stendahls.pod.DealerMapping;
import se.stendahls.pod.StartupStepResult;

public class MdHubStep {

    private MdHubDealerReader reader;
    private MdHubDealerProcessor processor;
    private MdHubStepResult result = new MdHubStepResult();

    public MdHubStep(MdHubDealerReader reader, MdHubDealerProcessor processor) {

        this.reader = reader;
        this.processor = processor;
    }

    public MdHubStep read(StartupStepResult startupResult) {

        Workbook book = reader.read(startupResult);
        result.setWorkbook(book);
        return this;

    }

    public MdHubStep process() {

        DealerMapping dm = processor.process(result.getWorkbook());
        result.setDealerMapping(dm);
        return this;
    }

    public MdHubStepResult getResult() {
        return result;
    }
}
