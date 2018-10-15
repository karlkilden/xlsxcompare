package se.stendahls.pod;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DealerTest {

    @Test
    public void create_dealer() {
        Dealer d = new Dealer();
    }

    @Test
    public void props() {
        GetterSetterVerifier getterSetterVerifier = GetterSetterVerifier.forClass(Dealer.class);
        getterSetterVerifier.verify();

    }
}