package se.stendahls.pod;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DealerMapping {

    private Map<String,Dealer> dealersByKey = new HashMap<>(3000);
    private Map<String,Dealer> dealersByName = new HashMap<>(3000);


    public void add(Dealer dealer) {
        dealersByKey.put(dealer.getKey(), dealer);
    }

    public Dealer getOrCreateMdHubDealer(String key) {
        return dealersByKey.computeIfAbsent(key, k -> new Dealer(k, true));
    }

    public Collection<Dealer> getDealers() {
        return dealersByKey.values();
    }

    public void addByName(String name, Dealer dealer) {
        dealersByName.put(name, dealer);
    }

    public Dealer byName(String name) {
        return dealersByName.get(name);
    }
}
