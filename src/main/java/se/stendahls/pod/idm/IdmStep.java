package se.stendahls.pod.idm;

import se.stendahls.pod.StartupStepResult;

public class IdmStep {
    private final IdmDealerReader reader;
    private final IdmDealerProcessor processor;
    private IdmStepResult idmStepResult = new IdmStepResult();

    public IdmStep(IdmDealerReader reader, IdmDealerProcessor processor) {
        this.reader = reader;
        this.processor = processor;
    }

    public IdmStep read(StartupStepResult startupResult) {
        idmStepResult.setIdmRaw(reader.read(startupResult));
        return this;
    }

    public IdmStep process() {
        idmStepResult.setDealerMapping(processor.process(idmStepResult.getIdmRaw()));
        return this;
    }

    public IdmStepResult getResult() {
        return idmStepResult;
    }

}
