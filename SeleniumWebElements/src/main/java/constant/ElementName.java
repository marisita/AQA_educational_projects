package constant;

public enum ElementName {
    
    BUTTON("button"),
    INPUT("input"),
    LABEL("label"),
    LINK("link");

    private String name;

    ElementName(String name) {
        this.name = name;
    }
}
