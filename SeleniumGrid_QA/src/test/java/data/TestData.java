package data;

public final class TestData {

    public enum BrowserName {

        FF("ff"),
        CHROME("chrome"),
        IE("ie")
        ;

        private String browserName;

        BrowserName(String browserName) {
            this.browserName = browserName;
        }

        @Override
        public String toString() {
            return browserName;
        }
    }

    public enum Url {

        LOCALHOST("http://localhost:4444/wd/hub"),
        GOOGLE("https://www.google.com.ua")
        ;

        private String url;

        Url(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return url;
        }
    }

    public enum TestSelector {

        SEARCH_INPUT_SELECTOR("#lst-ib"),
        SEARCH_RESULT_LINK(".srg h3.r>a")
        ;

        private String selector;

        TestSelector(String selector) {
            this.selector = selector;
        }

        @Override
        public String toString() {
            return selector;
        }
    }

    public enum TestAttribute {

        SEARCH_TEXT("YouTube"),
        URL_YOUTUBE("youtube.com")
        ;

        private String attribute;

        TestAttribute(String attribute) {
            this.attribute = attribute;
        }

        @Override
        public String toString() {
            return attribute;
        }
    }

    private TestData() {
    }
}
