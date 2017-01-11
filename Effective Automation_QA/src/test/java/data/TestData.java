package data;

public final class TestData {

    public static final class HttpClient {

        public static final String APACHE_HTTP_CLIENT = "Apache-HttpClient/4.1.1 (java 1.5)";

        private HttpClient() {
        }
    }

    public static final class Url {

        public static final String HOME_URL = "http://www.thomas-bayer.com/sqlrest/";
        public static final String CUSTOMER_URL = "CUSTOMER/";
        public static final String CUSTOMER_URL_INVALID = "CUSTOMERS/";
        public static final String PRODUCT_URL = "PRODUCT/";

        private Url() {
        }
    }

    public static final class CustomerAttributes {

        public static final String CUSTOMER_NODE_NAME = "CUSTOMER";
        public static final String ID_NODE_NAME = "ID";
        public static final String FIRSTNAME_NODE_NAME = "FIRSTNAME";
        public static final String LASTNAME_NODE_NAME = "LASTNAME";
        public static final String STREET_NODE_NAME = "STREET";
        public static final String CITY_NODE_NAME = "CITY";

        public static final String ID_PATTERN = "\\d+";
        public static final String FIRSTNAME_PATTERN = "[a-zA-z\\s]+";
        public static final String LASTNAME_PATTERN = "[a-zA-z\\s]+";
        public static final String STREET_PATTERN = "[a-zA-Z0-9.\\s]+";
        public static final String CITY_PATTERN = "[a-zA-z\\s]+";

        private CustomerAttributes() {
        }
    }

    public static final class ProductAttributes {

        public static final String PRODUCT_NODE_NAME = "PRODUCT";
        public static final String ID_NODE_NAME = "ID";
        public static final String NAME_NODE_NAME = "NAME";
        public static final String PRICE_NODE_NAME = "PRICE";

        public static final String ID_PATTERN = "\\d+";
        public static final String NAME_PATTERN = "[a-zA-z\\s]+";
        public static final String PRICE_PATTERN = "[0-9]+.[0-9]+";

        private ProductAttributes() {
        }
    }

    private TestData() {
    }
}
