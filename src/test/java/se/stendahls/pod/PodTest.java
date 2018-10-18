package se.stendahls.pod;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import se.stendahls.pod.idm.IdmDealerFileReader;
import se.stendahls.pod.idm.IdmDealerProcessor;
import se.stendahls.pod.idm.IdmStep;
import se.stendahls.pod.mdhub.MdHubDealerProcessor;
import se.stendahls.pod.mdhub.MdHubDealerReader;
import se.stendahls.pod.mdhub.MdHubStep;

import static org.junit.Assert.*;

public class PodTest {

    private Pod pod;

    private  StartupStep startupStep = Mockito.mock(StartupStep.class);
    private  IdmStep idmStep = Mockito.mock(IdmStep.class);
    private  MdHubStep mdHubStep = Mockito.mock(MdHubStep.class);
    private  FinalStep finalStep = Mockito.mock(FinalStep.class);

    @Before
    public void setUp() throws Exception {
        pod = new Pod(startupStep,idmStep,mdHubStep,finalStep);

    }

    @Test
    public void reads_config() {
        pod.run();
        Mockito.verify(startupStep).readConfig();
    }

    @Test
    public void reads_keyMapping() {
        pod.run();
        Mockito.verify(startupStep).readKeyMapping();
    }

    @Test
    public void runs() {

        StartupStep startupStep = new StartupStep(new ConfigReader(), new KeyMappingReader(), new KeyMappingProcessor());
        IdmStep idmStep = new IdmStep(new IdmDealerFileReader(), new IdmDealerProcessor());
        MdHubStep mdHubStep = new MdHubStep(new MdHubDealerReader(), new MdHubDealerProcessor());
        FinalStep finalStep = new FinalStep();
        Pod pod = new Pod(startupStep, idmStep, mdHubStep, finalStep);

        pod.run();
    }
}