package se.stendahls.pod;

import java.util.HashMap;
import java.util.Map;

public class DealerLocatorFields {


    public static class Neutral {
        public static final String ID = "ID";
        public static final String DISPLAY_NAME = "DISPLAY_NAME";
        public static final String PHONE_NUMBER = "PHONE_NUMBER";
        public static final String FAX_NUMBER = "FAX_NUMBER";
        public static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";
        public static final String URL= "URL";
        public static final String STREET_ADDRESS = "STREET_ADRESS";
        public static final String STREET_ADDRESS2 = "STREET_ADRESS2";
        public static final String POSTAL_CODE = "POSTAL_CODE";
        public static final String CITY = "CITY";
        public static final String STATE = "STATE";
        public static final String PROVINCE = "PROVINCE";
        public static final String COUNTRY = "COUNTRY";
        public static final String LATITUDE = "LATITUDE";
        public static final String LONGITUDE = "LONGITUDE";
        public static final String SHOW_IN_DL = "SHOW_IN_DL";
        public static final String PRODUCT_LINES = "PRODUCT_LINES";
        public static final String REGION = "REGION";

        public static final String FIELDS[] = new String[]{ID, DISPLAY_NAME, PHONE_NUMBER, FAX_NUMBER, EMAIL_ADDRESS,
                URL, STREET_ADDRESS, STREET_ADDRESS2, POSTAL_CODE, CITY, STATE, PROVINCE, COUNTRY,
        LATITUDE, LONGITUDE, SHOW_IN_DL, PRODUCT_LINES, REGION};
    }

    public static class Idm {
        public static final String ENTRY_NAME = "name";
        public static final String ID = "vebiz2coguid";
        public static final String DEALER_TYPE = "vebiz2cotype";
        public static final String DISPLAY_NAME = "displayname";
        public static final String PHONE_NUMBER = "telephonenumber";
        public static final String FAX_NUMBER = "facsimiletelephonenumber";
        public static final String EMAIL_ADDRESS = "mail";
        public static final String URL= "url";
        public static final String STREET_ADDRESS = "postaladdress";
        public static final String STREET_ADDRESS2 = "Vebiz2PostalAddress2";
        public static final String POSTAL_CODE = "postalcode";
        public static final String CITY = "l";
        public static final String STATE = "st";
        public static final String PROVINCE = "VeBiz2Province";
        public static final String COUNTRY = "vebiz2country";
        public static final String LATITUDE = "VeBiz2Latitude";
        public static final String LONGITUDE = "VeBiz2Longitude";
        public static final String SHOW_IN_DL = "vebiz2dlrlocdisplay";
        public static final String PRODUCT_LINES = "vebiz2productline";
        public static final String REGION = "region";

        public static final Map<String, String> FIELDS = new HashMap<>();

        static {
            FIELDS.put(Neutral.ID, Idm.ID);
            FIELDS.put(Neutral.DISPLAY_NAME, Idm.DISPLAY_NAME);

            FIELDS.put(Neutral.PHONE_NUMBER, Idm.PHONE_NUMBER);
            FIELDS.put(Neutral.FAX_NUMBER, Idm.FAX_NUMBER);
            FIELDS.put(Neutral.EMAIL_ADDRESS, Idm.EMAIL_ADDRESS);
            FIELDS.put(Neutral.URL, Idm.URL);
            FIELDS.put(Neutral.STREET_ADDRESS, Idm.STREET_ADDRESS);
            FIELDS.put(Neutral.STREET_ADDRESS2, Idm.STREET_ADDRESS2);
            FIELDS.put(Neutral.POSTAL_CODE, Idm.POSTAL_CODE);
            FIELDS.put(Neutral.CITY, Idm.CITY);
            FIELDS.put(Neutral.STATE, Idm.STATE);
            FIELDS.put(Neutral.PROVINCE, Idm.PROVINCE);
            FIELDS.put(Neutral.COUNTRY, Idm.COUNTRY);
            FIELDS.put(Neutral.LATITUDE, Idm.LATITUDE);
            FIELDS.put(Neutral.LONGITUDE, Idm.LONGITUDE);
            FIELDS.put(Neutral.SHOW_IN_DL, Idm.SHOW_IN_DL);
            FIELDS.put(Neutral.PRODUCT_LINES, Idm.PRODUCT_LINES);
            FIELDS.put(Neutral.REGION, Idm.REGION);
        }
    }

    public static class MdHub {
        public static final String ENTRY_NAME = "Distribution_Lowest Dist Long Name";
        public static final String ID = "Distribution_Lowest Dist CE Party ID";
        public static final String DISPLAY_NAME = "Distribution_Lowest Dist Long Name";
        public static final String PHONE_NUMBER = "Address_Telephone 2";
        public static final String FAX_NUMBER = "Address_Fax";
        public static final String EMAIL_ADDRESS = "Address_Email";
        public static final String URL= "Address_Website Url";
        public static final String STREET_ADDRESS = "Address_Address Line 1";
        public static final String STREET_ADDRESS2 = "Address_Address Line 2";
        public static final String STREET_ADDRESS3 = "Address_Address Line 3";

        public static final String POSTAL_CODE = "Address_Postal Code";
        public static final String CITY = "Address_City";
        public static final String STATE = "Address_State";
        public static final String PROVINCE = "Address_Province";

        public static final String COUNTRY1 = "Distribution_Dealer L1 Country Code";
        public static final String COUNTRY2 = "Distribution_Dealer L2 Country Code";
        public static final String COUNTRY3 = "Distribution_Dealer L3 Country Code";

        public static final String LATITUDE = "Address_Latitude";
        public static final String LONGITUDE = "Address_Longitude";
        public static final String SHOW_IN_DL = "Consumer Data_Dealer Locator Report";
        public static final String PRODUCT_LINES = "Product Lines_Product Line Name";
        public static final String REGION = "Distribution_Hub Name";
        public static final String COUNTRY_LVL = "Distribution_Lowest Level";


        public static final Map<String, String> FIELDS = new HashMap<>();


        static {
            FIELDS.put(Neutral.ID, MdHub.ID);
            FIELDS.put(Neutral.DISPLAY_NAME, MdHub.DISPLAY_NAME);
            FIELDS.put(Neutral.PHONE_NUMBER, MdHub.PHONE_NUMBER);
            FIELDS.put(Neutral.FAX_NUMBER, MdHub.FAX_NUMBER);
            FIELDS.put(Neutral.EMAIL_ADDRESS, MdHub.EMAIL_ADDRESS);
            FIELDS.put(Neutral.URL, MdHub.URL);
            FIELDS.put(Neutral.STREET_ADDRESS, MdHub.STREET_ADDRESS);
            FIELDS.put(Neutral.STREET_ADDRESS2, MdHub.STREET_ADDRESS2);
            FIELDS.put(Neutral.POSTAL_CODE, MdHub.POSTAL_CODE);
            FIELDS.put(Neutral.CITY, MdHub.CITY);
            FIELDS.put(Neutral.STATE, MdHub.STATE);
            FIELDS.put(Neutral.PROVINCE, MdHub.PROVINCE);

            FIELDS.put(Neutral.LATITUDE, MdHub.LATITUDE);
            FIELDS.put(Neutral.LONGITUDE, MdHub.LONGITUDE);
            FIELDS.put(Neutral.SHOW_IN_DL, MdHub.SHOW_IN_DL);
            FIELDS.put(Neutral.PRODUCT_LINES, MdHub.PRODUCT_LINES);
            FIELDS.put(Neutral.REGION, MdHub.REGION);
            FIELDS.put("L1", MdHub.COUNTRY1);
            FIELDS.put("L2", MdHub.COUNTRY2);
            FIELDS.put("L3", MdHub.COUNTRY3);





        }
    }


    private DealerLocatorFields() {

    }
}
