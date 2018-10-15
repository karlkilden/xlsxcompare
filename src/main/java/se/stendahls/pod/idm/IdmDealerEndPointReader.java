package se.stendahls.pod.idm;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;

public class IdmDealerEndPointReader implements IdmDealerReader {

    @Override
    public IdmRaw read() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://net.volvoce.com/ilfdealerlocator/xml/enterprise.xml")
                         .build();

        try {
            Response response = client.newCall(request).execute();

          String xml = response.body().string();
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
