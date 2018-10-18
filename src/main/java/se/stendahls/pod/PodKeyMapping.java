package se.stendahls.pod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PodKeyMapping {

    Map<String, List<String>> partyIdsToGuids = new HashMap<>(2000);
    Map<String, String> guidToPartyId = new HashMap<>(2000);


    public void add(String partyId, String guid) {
        guidToPartyId.put(guid,partyId);
        partyIdsToGuids.computeIfAbsent(partyId, (key -> new ArrayList<>())).add(guid);

    }

    public Map<String, List<String>> getPartyIdsToGuids() {
        return partyIdsToGuids;
    }

    public Map<String, String> getGuidToPartyId() {
        return guidToPartyId;
    }
}
