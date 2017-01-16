package data;

public class TestData {

    public enum Url {

        BASE_URL ("http://rozetka.com.ua/");

        String url;

        Url(java.lang.String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return url;
        }
    }

    public enum Waiter {

        PAGE_LOAD_TIME_OUT(50),
        SET_SCRIPT_TIME_OUT(50),
        IMPLICITLY_WAIT(50);

        long waitMillis;

        Waiter(int waitMillis) {
            this.waitMillis = waitMillis;
        }

        public long getWaitMillis() {
            return waitMillis;
        }
    }

    public enum Selector {

        SEARCH_INPUT_SELECTOR(".rz-header-search-input-text"),
        SEARCH_BUTTON_SELECTOR(".btn-link-i"),
        SEARCH_RESULT_TITLE_SELECTOR("#search_result_title_text"),
        SEARCH_RESULTS_TITLE_SELECTOR("div.g-i-tile-i-title.clearfix > a"),
        SEARCH_RESULT_NOTHING_TEXT_SELECTOR(".search-result-title-nothing-text"),
        CATEGORY_LINK_SELECTOR(".f-menu-l-i:nth-child(3) > a"),
        CATEGORY_TEXT_SELECTOR("h1.pab-h1");

        String selector;

        Selector(String selector) {
            this.selector = selector;
        }

        @Override
        public String toString() {
            return selector;
        }
    }

    public enum TestAttributes {

        SEARCH_TEXT_INVALID("lalala"),
        SEARCH_TEXT_VALID("lenovo"),
        SEARCH_TEXT_NOTHING("ничего не найдено"),
        CATEGORY_TEXT("Бытовая техника");

        String attribute;

        TestAttributes(String attribute) {
            this.attribute = attribute;
        }

        @Override
        public String toString() {
            return attribute;
        }
    }
}
