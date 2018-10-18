package se.stendahls.pod.idm;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import se.stendahls.pod.StartupStepResult;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IdmDealerFileReader implements IdmDealerReader {

    @Override
    public IdmRaw read(StartupStepResult result) {

        try {
            String xml = new String(Files.readAllBytes(Paths.get(result.getConfig().getIdmFile())), Charset.forName("utf-16"));
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            IdmRaw raw =
                    xmlMapper.readValue(xml,
                            IdmRaw.class);
            return raw;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
