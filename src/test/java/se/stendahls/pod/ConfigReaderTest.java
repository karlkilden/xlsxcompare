package se.stendahls.pod;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class ConfigReaderTest {

    @Test
    public void readDict() {
        ConfigReader cr = new ConfigReader();

        cr.readConfig();
    }

    @Test
    public void locale() {
        Locale l = new Locale("EN", "FR");

        System.out.println(l.getDisplayCountry(Locale.US));
    }
}