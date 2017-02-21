package data;

public enum Url {

    LOCALHOST("http://localhost:4444/wd/hub"),
    GOOGLE("https://www.google.com.ua")
    ;

    private String url;

    Url(String url) {
        this.url = url;
    }

    public String getValue() {
        return url;
    }
}
