package constant;

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
