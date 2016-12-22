package converter;

import constants.FormBean;
import domain.User;
import servlet.bean.UserBean;

import javax.servlet.http.HttpServletRequest;

public class UserConverter {

    public static UserBean convert(HttpServletRequest request) {

        String login = request.getParameter(FormBean.RegisterParameters.LOGIN);
        String password = request.getParameter(FormBean.RegisterParameters.PASSWORD);
        String repeatedPassword = request.getParameter(FormBean.RegisterParameters.REPEATED_PASSWORD);
        String firstName = request.getParameter(FormBean.RegisterParameters.FIRST_NAME);
        String lastName = request.getParameter(FormBean.RegisterParameters.LAST_NAME);
        String email = request.getParameter(FormBean.RegisterParameters.EMAIL);
        String sex = request.getParameter(FormBean.RegisterParameters.SEX);

        return  new UserBean(login, password, repeatedPassword, firstName, lastName, email, sex);
    }

    public static UserBean convert(User user) {

        String login = user.getLogin();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String sex = user.getSex();

        return new UserBean(login, null, null, firstName, lastName, email, sex);
    }

    public static User convert(UserBean userBean) {

        String login = userBean.getLogin();
        String password = userBean.getPassword();
        String firstName = userBean.getFirstName();
        String lastName = userBean.getLastName();
        String email = userBean.getEmail();
        String sex = userBean.getSex();

        return new User(login, password, firstName, lastName, email, sex);
    }

}
