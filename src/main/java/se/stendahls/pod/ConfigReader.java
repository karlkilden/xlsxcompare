package se.stendahls.pod;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hjson.JsonObject;
import org.hjson.JsonValue;
import se.stendahls.pod.idm.IdmRaw;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class ConfigReader {


    public StartupConfig readConfig() {

        try {
            String hjson = new String(Files.readAllBytes(Paths.get("config.hjson")), Charset.forName("utf-8"));

            JsonObject json = JsonValue.readHjson(hjson).asObject();

            StartupConfig config = new StartupConfig();
            config.setIdmEndPoint(json.get("idmEndPoint").asString());
            config.setIdmFile(json.get("IdmFile").asString());
            config.setMdHubExcel(json.get("mdHubExcel").asString());
            config.setKeyMappingExcel(json.get("keyMappingExcel").asString());
            config.setUseIgnore(json.get("useIgnore").asBoolean());
            config.setSkipWhenBothShowInDlNo(json.get("skipWhenBothShowInDlNo").asBoolean());

            return config;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
