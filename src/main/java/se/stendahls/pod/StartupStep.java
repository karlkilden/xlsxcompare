package se.stendahls.pod;

public class StartupStep {

    private StartupStepResult result;

    private ConfigReader configReader;
    private KeyMappingReader keyMappingReader;

    public StartupStep(ConfigReader configReader, KeyMappingReader keyMappingReader) {
        this.configReader = configReader;
        this.keyMappingReader = keyMappingReader;

        result = new StartupStepResult();
    }

    public StartupStep readConfig() {
        result.setConfig(configReader.readConfig());
        return this;
    }

    public StartupStep readKeyMapping() {
        result.setKeyMapping(keyMappingReader.readKeyMapping());
        return this;
    }

    public StartupStepResult getResult() {
        return result;
    }
}
