package data;

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
