package se.stendahls.pod;

public class StartupConfig {

    private String keyMappingExcel;
    private String mdHubExcel;
    private String IdmFile;
    private String idmEndPoint;
    private boolean useIgnore;
    private boolean skipWhenBothShowInDlNo;


    public String getKeyMappingExcel() {
        return keyMappingExcel;
    }

    public void setKeyMappingExcel(String keyMappingExcel) {
        this.keyMappingExcel = keyMappingExcel;
    }

    public String getMdHubExcel() {
        return mdHubExcel;
    }

    public void setMdHubExcel(String mdHubExcel) {
        this.mdHubExcel = mdHubExcel;
    }

    public String getIdmFile() {
        return IdmFile;
    }

    public void setIdmFile(String idmFile) {
        IdmFile = idmFile;
    }

    public String getIdmEndPoint() {
        return idmEndPoint;
    }

    public void setIdmEndPoint(String idmEndPoint) {
        this.idmEndPoint = idmEndPoint;
    }

    public boolean isUseIgnore() {
        return useIgnore;
    }

    public void setUseIgnore(boolean useIgnore) {
        this.useIgnore = useIgnore;
    }

    public boolean isSkipWhenBothShowInDlNo() {
        return skipWhenBothShowInDlNo;
    }

    public void setSkipWhenBothShowInDlNo(boolean skipWhenBothShowInDlNo) {
        this.skipWhenBothShowInDlNo = skipWhenBothShowInDlNo;
    }
}
