package se.stendahls.pod.idm;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IdmDealerFileReader implements IdmDealerReader {

    @Override
    public IdmRaw read() {

        try {
            String xml = new String(Files.readAllBytes(Paths.get("enterprise.xml")), Charset.forName("utf-16"));
            XmlMapper xmlMapper = new XmlMapper();
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
