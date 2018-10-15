package se.stendahls.pod.idm;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IdmRawEntry {

    private String name;
    @JacksonXmlElementWrapper(useWrapping=false)
    @JacksonXmlProperty(localName = "entry")
    private IdmRawEntry[] entries;

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    @JacksonXmlElementWrapper(useWrapping=false)
    @JacksonXmlProperty(localName = "attribute")
    public Attribute[] attributes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdmRawEntry[] getEntries() {
        return entries;
    }

    public void setEntries(IdmRawEntry[] entries) {
        this.entries = entries;
    }
}
