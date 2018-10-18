package se.stendahls.pod;

import se.stendahls.pod.idm.IdmStep;
import se.stendahls.pod.idm.IdmStepResult;
import se.stendahls.pod.mdhub.MdHubStep;
import se.stendahls.pod.mdhub.MdHubStepResult;

public class Pod {


    private final StartupStep startupStep;
    private final IdmStep idmStep;
    private final MdHubStep mdHubStep;
    private final FinalStep finalStep;

    public Pod(StartupStep startupStep, IdmStep idmStep, MdHubStep mdHubStep, FinalStep finalStep) {
        this.startupStep = startupStep;
        this.idmStep = idmStep;
        this.mdHubStep = mdHubStep;
        this.finalStep = finalStep;
    }

    public PodResult run() {

        startupStep.readConfig();
        startupStep.readKeyMapping();
        startupStep.process();
        StartupStepResult startupResult = startupStep.getResult();

        idmStep.read(startupResult);
        idmStep.process();
        IdmStepResult idmStepResult = idmStep.getResult();

        mdHubStep.read(startupResult);
        mdHubStep.process();
        MdHubStepResult mdHubStepResult = mdHubStep.getResult();

        finalStep.read(startupResult, idmStepResult, mdHubStepResult);


        return null;
    }
}
