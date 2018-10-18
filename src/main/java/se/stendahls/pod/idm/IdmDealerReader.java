package se.stendahls.pod.idm;

import se.stendahls.pod.StartupStepResult;

public interface IdmDealerReader {


    IdmRaw read(StartupStepResult result);

}
