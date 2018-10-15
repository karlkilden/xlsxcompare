package se.stendahls.pod.mdhub;

import org.junit.Test;

import static org.junit.Assert.*;

public class MdHubDealerReaderTest {

    @Test
    public void readFile() {
        MdHubDealerReader reader = new MdHubDealerReader();

        reader.read(null);
    }
}