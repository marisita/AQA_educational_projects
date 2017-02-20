package data;

public enum TestAttribute {

    SEARCH_TEXT("YouTube"),
    URL_YOUTUBE("youtube")
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
