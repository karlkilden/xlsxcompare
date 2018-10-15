package se.stendahls.pod;

public class StartupStepResult {
    private StartupConfig config;
    private PodKeyMapping keyMapping;

    public void setConfig(StartupConfig config) {
        this.config = config;
    }

    public StartupConfig getConfig() {
        return config;
    }

    public void setKeyMapping(PodKeyMapping keyMapping) {
        this.keyMapping = keyMapping;
    }

    public PodKeyMapping getKeyMapping() {
        return keyMapping;
    }
}
