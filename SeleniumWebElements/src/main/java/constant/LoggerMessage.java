package constant;

public enum LoggerMessage {

    CANNOT_FIND_ELEMENT("cannot find ?"),
    CLICKED("was clicked on ?"),
    CLEARED("was cleared ?"),
    INPUTTED("was inputted to ?"),
    GET_TEXT("get text from ?");

    private String message;

    LoggerMessage(String message) {
        this.message = message;
    }
}

