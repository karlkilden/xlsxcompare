package se.stendahls.pod;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import se.stendahls.pod.idm.*;

public class IdmDealerFetcherTest {

    @Test
    public void fetch_idm_data() {
        IdmDealerReader idmReader = new IdmDealerFileReader();

  //      IdmRaw raw = idmReader.read();
   //     IdmRawEntry entry = raw.getEntry();

  //      writeAllNames(entry);

    }

    private void writeAllNames(IdmRawEntry entry) {
        if(StringUtils.isNotEmpty(entry.getName())) {
            Dealer dealer = new Dealer();
            String region = null;
            String[] splitName = entry.getName().split(",");
            if (splitName.length >1) {
                region = splitName[2].replace("OU=", "");
                System.out.println(region);
            }
            for(Attribute a: entry.getAttributes()) {

                System.out.println("a type: " + a.getType());
                System.out.println("a name : " + a.getName());
                System.out.println("a value: " + a.getValue());

            }
        }
        System.out.println();
        if (entry.getEntries() == null) {
            return;
        }
        for(IdmRawEntry e: entry.getEntries()) {
            writeAllNames(e);
        }
    }
}