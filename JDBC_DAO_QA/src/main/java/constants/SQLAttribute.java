package constants;

public final class SQLAttribute {

    public static final class SQLColumnName{

        public static final String ID_COLUMN = "id";
        public static final String LOGIN_COLUMN = "login";
        public static final String PASSWORD_COLUMN = "password";
        public static final String FIRST_NAME_COLUMN = "firstName";
        public static final String LAST_NAME_COLUMN = "lastName";
        public static final String EMAIL_COLUMN = "email";
        public static final String SEX_COLUMN = "sex";
        
        private SQLColumnName() {

        }
    }

    public final class SQLStatements {

        public static final String LOGIN_USER_STATEMENT = "SELECT * FROM user WHERE login=? AND password=?";
        public static final String REGISTER_USER_STATEMENT = "INSERT INTO `users`.`user` (`login`, `password`, `firstName`, `lastName`, `email`, `sex`) VALUES (?, ?, ?, ?, ?, ?);";
        public static final String IS_USER_EXIST_STATEMENT = "SELECT * FROM user WHERE login=?";

        private SQLStatements() {

        }
    }

    private SQLAttribute(){

    }
}
