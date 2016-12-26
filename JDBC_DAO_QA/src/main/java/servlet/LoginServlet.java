package servlet;

import constants.FormBean;
import constants.MyAttribute;
import converter.UserConverter;
import domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.UserServiceImpl;
import service.api.UserService;
import servlet.bean.ErrorBean;
import servlet.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static constants.LoggerInfoMessage.USER_WAS_CONVERTED_FROM_DOMAIN;
import static constants.LoggerInfoMessage.USER_WAS_LOGGED;
import static constants.MyUrl.ERROR_URL;
import static constants.MyUrl.LOGIN_SUCCESSFULLY_URL;
import static constants.ValidatorMessage.LogIn.INVALID_LOGIN_OR_PASSWORD;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = (UserServiceImpl) request.getServletContext().getAttribute(MyAttribute.MyServletContextListener.USER_SERVICE);
        List<String> errors = new ArrayList<>();

        String login = request.getParameter(FormBean.LoginParameters.LOGIN);
        String password = request.getParameter(FormBean.LoginParameters.PASSWORD);
        User user = userService.login(login, password);

        if (user != null) {
            LOGGER.info(USER_WAS_LOGGED + user);
            UserConverter userConverter = new UserConverter();
            UserBean userBean = userConverter.convert(user);
            LOGGER.info(USER_WAS_CONVERTED_FROM_DOMAIN + user);
            request.setAttribute(FormBean.Attributes.LOGIN_FORM_BEAN, userBean);
            getServletContext().getRequestDispatcher(LOGIN_SUCCESSFULLY_URL).forward(request, response);
        } else {
            LOGGER.error(INVALID_LOGIN_OR_PASSWORD);
            errors.add(INVALID_LOGIN_OR_PASSWORD);
            ErrorBean errorBean = new ErrorBean(errors.toString());
            request.setAttribute(FormBean.Attributes.ERROR_FORM_BEAN, errorBean);
            getServletContext().getRequestDispatcher(ERROR_URL).forward(request, response);
        }
    }
}
