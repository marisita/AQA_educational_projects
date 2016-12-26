package constants;

public final class FormBean {

    public static final class Attributes {

        public static final String LOGIN_FORM_BEAN = "loginFormBean";
        public static final String REGISTER_FORM_BEAN = "registerFormBean";
        public static final String ERROR_FORM_BEAN ="errorFormBean";

        private Attributes() {
        }
    }

    public static final class LoginParameters {

        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";

        private LoginParameters(){
        }
    }

    public static final class RegisterParameters {

        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
        public static final String REPEATED_PASSWORD = "repeatedPassword";
        public static final String FIRST_NAME = "firstName";
        public static final String LAST_NAME = "lastName";
        public static final String EMAIL = "email";
        public static final String SEX = "sex";

        private RegisterParameters(){
        }
    }

    private FormBean() {
    }
}
