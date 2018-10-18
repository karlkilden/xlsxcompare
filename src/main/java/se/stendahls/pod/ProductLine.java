package se.stendahls.pod;

import java.util.HashMap;
import java.util.Map;

public class ProductLine {

    public static String lines = "Large Soil Compactors\tA\n" +
            "Large Asphalt Compactors\tB\n" +
            "Material Transfer Vehicles\tC\n" +
            "Small Asphalt Compactors\tD\n" +
            "Small Soil Compactors\tE\n" +
            "Compact Equipment\tF\n" +
            "Blaw-Knox Pavers\tG\n" +
            "Road Wideners\tH\n" +
            "Milling Equipment\tI\n" +
            "ABG Pavers\tJ\n" +
            "Skidsteer Loaders\tK\n" +
            "Wheeled Excavators\tL\n" +
            "Wheel Loaders\tM\n" +
            "Motor Graders\tN\n" +
            "Crawler Excavators\tO\n" +
            "Compact Wheel Loaders\tP\n" +
            "Compact Excavators\tQ\n" +
            "Backhoe Loaders\tR\n" +
            "Articulated Haulers\tS\n" +
            "Compaction\tT";


    public static Map<String, String> codedProductLines = new HashMap<>();

    static {

        codedProductLines.put("Large Soil Compactors", "A");
        codedProductLines.put("Large Asphalt Compactors", "B");
        codedProductLines.put("Material Transfer Vehicles", "C");
        codedProductLines.put("Small Asphalt Compactors", "D");
        codedProductLines.put("Small Soil Compactors", "E");
        codedProductLines.put("Compact Equipment", "F");
        codedProductLines.put("Blaw-Knox Pavers", "G");
        codedProductLines.put("Road Wideners", "H");
        codedProductLines.put("Milling Equipment", "I");
        codedProductLines.put("ABG Pavers", "J");
        codedProductLines.put("Skidsteer Loaders", "K");
        codedProductLines.put("Wheeled Excavators", "L");
        codedProductLines.put("Wheel Loaders", "M");
        codedProductLines.put("Motor Graders", "N");
        codedProductLines.put("Crawler Excavators", "O");
        codedProductLines.put("Compact Wheel Loaders", "P");
        codedProductLines.put("Compact Excavators", "Q");
        codedProductLines.put("Backhoe Loaders", "R");
        codedProductLines.put("Articulated Haulers", "S");
        codedProductLines.put("Compaction", "T");


    }
}