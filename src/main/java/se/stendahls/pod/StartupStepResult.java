package se.stendahls.pod;

import org.apache.poi.ss.usermodel.Workbook;

public class StartupStepResult {
    private StartupConfig config;
    private PodKeyMapping keyMapping;
    private Workbook keyMappingWorkbook;

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

    public void setKeyMappingWorkbook(Workbook keyMappingWorkbook) {
        this.keyMappingWorkbook = keyMappingWorkbook;
    }

    public Workbook getKeyMappingWorkBook() {
        return keyMappingWorkbook;
    }
}
