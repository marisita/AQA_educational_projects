package servlet.bean;

public class UserBean {

    private String login;
    private String password;
    private String repeatedPassword;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;

    public UserBean(String login, String password, String repeatedPassword,
                    String firstName, String lastName, String email, String sex) {
        this.login = login;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", repeatedPassword='" + repeatedPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBean userBean = (UserBean) o;

        if (login != null ? !login.equals(userBean.login) : userBean.login != null) return false;
        if (password != null ? !password.equals(userBean.password) : userBean.password != null) return false;
        if (repeatedPassword != null ? !repeatedPassword.equals(userBean.repeatedPassword) : userBean.repeatedPassword != null)
            return false;
        if (firstName != null ? !firstName.equals(userBean.firstName) : userBean.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userBean.lastName) : userBean.lastName != null) return false;
        if (email != null ? !email.equals(userBean.email) : userBean.email != null) return false;
        return sex != null ? sex.equals(userBean.sex) : userBean.sex == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (repeatedPassword != null ? repeatedPassword.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
