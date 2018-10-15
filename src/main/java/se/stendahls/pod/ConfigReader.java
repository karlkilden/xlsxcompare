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


    JsonObject json = JsonValue.readHjson("{\n" +
            "  first: test,test,test\n" +
            "  second: 2\n" +
            "}").asObject();

    String f = json.get("first").asString();

    public StartupConfig readConfig() {



        try {
            String hjson = new String(Files.readAllBytes(Paths.get("dictionary.hjson")), Charset.forName("utf-8"));

            JsonObject json = JsonValue.readHjson(hjson).asObject();

            Object f = json.get("COUNTRY").asArray();
            f.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
