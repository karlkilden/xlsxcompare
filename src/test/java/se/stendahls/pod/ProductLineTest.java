package se.stendahls.pod;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductLineTest {

    @Test
    public void name() {
        String[] split = ProductLine.lines.split("\n");

        for (String s :split){
            String[] ab = s.split("\t");
            System.out.println("codedProductLines.put(\""+ab[0]+"\",\""+ab[1]+"\");");
        }
    }
}