package se.stendahls.pod.idm;

import org.apache.commons.lang3.StringUtils;
import se.stendahls.pod.Dealer;
import se.stendahls.pod.DealerLocatorFields;
import se.stendahls.pod.DealerMapping;

public class IdmDealerProcessor {
    DealerMapping dm = new DealerMapping();

    public IdmDealerProcessor() {
    }

    public DealerMapping process(IdmRaw idmRaw) {


        return createDealers(idmRaw.getEntry());

    }


    private DealerMapping createDealers(IdmRawEntry entry) {
        if (StringUtils.isNotEmpty(entry.getName())) {
            Dealer dealer = new Dealer();
            String region = null;
            String[] splitName = entry.getName().split(",");
            if (splitName.length > 5) {
                String n = splitName[splitName.length - 6];
                region = n.replace("OU=", "");
                dealer.addFieldValue(DealerLocatorFields.Idm.REGION, region);
            }
            for (Attribute a : entry.getAttributes()) {
                if (DealerLocatorFields.Idm.ID.equals(a.getName())) {
                    dealer.setKey(a.getValue()[0]);
                }

                if (a.getName().equals(DealerLocatorFields.Idm.DISPLAY_NAME)) {
                    dm.addByName(a.getValue()[0], dealer);
                }
                if (a.getValue() != null) {


                    for (String v : a.getValue()) {

                     
                     
                            dealer.addFieldValue(a.getName(), v);

                    }
                }


                dm.add(dealer);

            }
        }
        if (entry.getEntries() == null) {
            return dm;
        }
        for (IdmRawEntry e : entry.getEntries()) {
            createDealers(e);
        }
        return dm;
    }


}
