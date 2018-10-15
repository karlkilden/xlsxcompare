package se.stendahls.pod;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProblemRowTest {
    @Test
    public void props() {
        GetterSetterVerifier getterSetterVerifier = GetterSetterVerifier.forClass(ProblemRow.class);
        getterSetterVerifier.verify();

    }
}