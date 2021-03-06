package se.stendahls.pod;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class StartupStepTest {

    private ConfigReader configReader;
    private KeyMappingReader keyMappingReader;
    KeyMappingProcessor processor;
    StartupStep step;

    @Before
    public void setUp() throws Exception {
        configReader = Mockito.mock(ConfigReader.class);
        keyMappingReader = Mockito.mock(KeyMappingReader.class);
        processor = Mockito.mock(KeyMappingProcessor.class);
        step = new StartupStep(configReader, keyMappingReader, processor);

    }

    @Test
    public void readConfig_uses_reader() {
        step.readConfig();
        Mockito.verify(configReader).readConfig();
    }

    @Test
    public void readConfig_updates_result() {
        Mockito.when(configReader.readConfig()).thenReturn(new StartupConfig());
        StartupStepResult result = step.readConfig().getResult();
        Assertions.assertThat(result.getConfig()).isNotNull();
    }

    @Test
    public void readMapping_uses_reader() {
        step.readKeyMapping();
        Mockito.verify(keyMappingReader).read(new StartupConfig());
    }

    @Test
    public void readMapping_updates_result() {
        Mockito.when(keyMappingReader.read(new StartupConfig())).thenReturn(null);
        StartupStepResult result = step.readKeyMapping().getResult();
        Assertions.assertThat(result.getKeyMapping()).isNotNull();
    }
}