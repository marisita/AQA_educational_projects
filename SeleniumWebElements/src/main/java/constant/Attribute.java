package constant;

public final class Attribute {

    public enum ElementName {

        BUTTON("button"),
        INPUT("input"),
        LABEL("label"),
        LINK("link");

        private String message;

        ElementName(String message) {
            this.message = message;
        }
    }

    public enum LoggerMessage {

        CANNOT_FIND_ELEMENT("cannot find ?"),
        CLICKED("was clicked on ?"),
        CLEARED("was cleared ?"),
        INPUTTED("was inputted to ?")
        ;

        private String message;

        LoggerMessage(String message) {
            this.message = message;
        }
    }

    private Attribute() {
    }
}
