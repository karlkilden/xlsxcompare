package se.stendahls.pod.idm;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import se.stendahls.pod.DealerMapping;
import se.stendahls.pod.StartupStepResult;

public class IdmStepTest {

    private IdmDealerReader reader;
    private IdmDealerProcessor processor;
    private IdmStep step;
    private StartupStepResult startupResult;

    @Before
    public void setUp() throws Exception {
        reader = Mockito.mock(IdmDealerReader.class);
        processor = Mockito.mock(IdmDealerProcessor.class);
        step = new IdmStep(reader,processor);
        startupResult = new StartupStepResult();
    }

    @Test
    public void read() {
        step.read(startupResult);
        Mockito.verify(reader).read(startupResult);
    }

    @Test
    public void process() {
        IdmRaw raw = new IdmRaw();
        step.getResult().setIdmRaw(raw);
        step.process();

        Mockito.verify(processor).process(raw);
    }

    @Test
    public void read_sets_result() {
        Mockito.when(reader.read(startupResult)).thenReturn(new IdmRaw());
        StartupStepResult startupResult = new StartupStepResult();
        step.read(startupResult);
        IdmStepResult result = step.getResult();
        Assertions.assertThat(result.getIdmRaw()).isNotNull();
    }

    @Test
    public void process_sets_result() {
        IdmRaw raw = new IdmRaw();
        Mockito.when(processor.process(raw)).thenReturn(new DealerMapping());
        step.getResult().setIdmRaw(raw);
        step.process();
        IdmStepResult result = step.getResult();
        Assertions.assertThat(result.getDealerMapping()).isNotNull();
    }
}