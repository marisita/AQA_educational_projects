package constants;

public final class ValidatorMessage {

    public static final class Register {

        public static final String EMPTY_LOGIN = "Login is empty";
        public static final String INVALID_LOGIN_LENGTH = "Login has invalid length";
        public static final String LOGIN_CONTAINS_FORBIDDEN_SYMBOL = "Login contains forbidden symbol";

        public static final String EMPTY_PASSWORD = "Password is empty";
        public static final String INVALID_PASSWORD_LENGTH = "Password has invalid length";
        public static final String PASSWORD_CONTAINS_FORBIDDEN_SYMBOL = "Password contains forbidden symbol";
        public static final String PASSWORDS_NOT_MATCHES = "Password is not matches";

        public static final String EMPTY_FIRST_NAME = "First name is empty";
        public static final String FIRST_NAME_CONTAINS_FORBIDDEN_SYMBOL = "First name contains forbidden symbol";

        public static final String EMPTY_LAST_NAME = "Last name is empty";
        public static final String LAST_NAME_CONTAINS_FORBIDDEN_SYMBOL = "Last name contains forbidden symbol";

        public static final String EMPTY_EMAIL = "Email is empty";
        public static final String INVALID_EMAIL = "Email is invalid";

        private Register() {

        }
    }

    private ValidatorMessage() {
    }
}
