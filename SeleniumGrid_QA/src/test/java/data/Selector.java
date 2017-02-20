package data;

public enum Selector {

    SEARCH_INPUT_SELECTOR("#lst-ib"),
    SEARCH_RESULT_LINK(".srg h3.r>a")
    ;

    private String selector;

    Selector(String selector) {
        this.selector = selector;
    }

    @Override
    public String toString() {
        return selector;
    }
}
