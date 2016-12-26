package utils;

import domain.User;
import servlet.bean.UserBean;

public final class TestData {

    public static final String TEST_LOGIN = "anna";
    public static final String TEST_PASSWORD = "anna123";
    public static final User TEST_USER = new User("anna", "anna123", "anna", "red", "anna@gmail.com", "female");
    public static final UserBean TEST_USER_BEAN_OUTPUT = new UserBean("anna", null, null, "anna", "red", "anna@gmail.com", "female");
    public static final UserBean TEST_USER_BEAN_VALID = new UserBean("anna", "anna123", "anna123", "anna", "red", "anna@gmail.com", "female");
    public static final UserBean TEST_USER_BEAN_INVALID_LOGIN = new UserBean("anna._", "anna123", "anna123", "anna", "red", "anna@gmail.com", "female");
    public static final UserBean TEST_USER_BEAN_INVALID_PASSWORD = new UserBean("anna", "ann", "ann", "anna", "red", "anna@gmail.com", "female");
    public static final UserBean TEST_USER_BEAN_INVALID_PASSWORDS = new UserBean("anna", "anna", "anna123", "anna", "red", "anna@gmail.com", "female");
    public static final UserBean TEST_USER_BEAN_INVALID_EMAIL = new UserBean("anna", "anna123", "anna123", "anna", "red", "anna.gmail.com", "female");
    public static final UserBean TEST_USER_BEAN_EMPTY_EMAIL = new UserBean("anna", "anna123", "anna123", "anna", "red", "", "female");

    private TestData() {

    }
}
