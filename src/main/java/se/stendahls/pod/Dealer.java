package se.stendahls.pod;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Dealer {

    private Map<String,String> fields = new HashMap<>();

    private String key;
    private boolean isMdHub;

    public Dealer(String key) {
        this.key = key;
    }

    public Dealer() {
    }

    public Dealer(String key, boolean isMdHub) {
        this.key = key;
        this.isMdHub = isMdHub;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void addFieldValue(String name, String value) {

        if (ProductLine.codedProductLines.containsKey(value))    {

            value = ProductLine.codedProductLines.get(value);
        }

        String existingValue = fields.get(name);
        if (StringUtils.isNotEmpty(existingValue) && !StringUtils.equals(existingValue,value) && StringUtils.isNotEmpty(value)) {
         value = existingValue + ", " + value;
        }
        fields.put(name,value);
    }

    public String getField(String key) {
        return fields.getOrDefault(key,"");
    }

    public boolean isMdHub() {
        return isMdHub;
    }
}
