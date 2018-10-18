package se.stendahls.pod;

public class StartupStep {

    private StartupStepResult result;

    private ConfigReader configReader;
    private KeyMappingReader keyMappingReader;
    private KeyMappingProcessor processor;


    public StartupStep(ConfigReader configReader, KeyMappingReader keyMappingReader, KeyMappingProcessor processor) {
        this.configReader = configReader;
        this.keyMappingReader = keyMappingReader;
        this.processor = processor;

        result = new StartupStepResult();
    }

    public StartupStep readConfig() {
        result.setConfig(configReader.readConfig());
        return this;
    }

    public StartupStep readKeyMapping() {
        result.setKeyMappingWorkbook(keyMappingReader.read(result.getConfig()));
        return this;
    }
    public StartupStep process() {
        result.setKeyMapping(processor.process(result.getKeyMappingWorkBook()));
        return this;
    }

    public StartupStepResult getResult() {
        return result;
    }
}
