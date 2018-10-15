package se.stendahls.pod.idm;

public class IdmRaw {
    private String name;
    private IdmRawEntry entry;

    public IdmRaw() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdmRawEntry getEntry() {
        return entry;
    }

    public void setEntry(IdmRawEntry entry) {
        this.entry = entry;
    }
}
