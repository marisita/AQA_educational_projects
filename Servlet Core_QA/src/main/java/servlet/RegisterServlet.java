package servlet;

import constants.FormBean;
import constants.MyAttribute;
import converter.UserConverter;
import domain.User;
import exception.UserExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.UserServiceImpl;
import service.api.UserService;
import servlet.bean.ErrorBean;
import servlet.bean.UserBean;
import validator.RegisterValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static constants.LoggerInfoMessage.*;
import static constants.MyUrl.ERROR_URL;
import static constants.MyUrl.REGISTER_SUCCESSFULLY_URL;
import static constants.ExceptionMessage.DB_ERROR;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(RegisterServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = (UserServiceImpl) request.getServletContext().getAttribute(MyAttribute.MyServletContextListener.USER_SERVICE);
        List<String> errors = new ArrayList<>();

        UserBean userBean = UserConverter.convert(request);
        LOGGER.info(USER_WAS_CONVERTED_FROM_REQUEST + userBean);
        errors.addAll(RegisterValidator.validate(userBean));

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            ErrorBean errorBean = new ErrorBean(errors.toString());
            request.setAttribute(FormBean.Attributes.ERROR_FORM_BEAN, errorBean);
            getServletContext().getRequestDispatcher(ERROR_URL).forward(request, response);
            return;
        }

        User user = UserConverter.convert(userBean);
        LOGGER.info(USER_WAS_CONVERTED_FROM_BEAN + user);
        User registeredUser = null;

        try {
            registeredUser = userService.register(user);
        } catch (UserExistException e) {
            errors.add(e.getMessage());
        }

        if (registeredUser != null) {
            LOGGER.info(USER_WAS_REGISTERED + registeredUser);
            request.setAttribute(FormBean.Attributes.REGISTER_FORM_BEAN, userBean);
            getServletContext().getRequestDispatcher(REGISTER_SUCCESSFULLY_URL).forward(request, response);
        } else {
            errors.add(DB_ERROR);
            LOGGER.error(errors);
            ErrorBean errorBean = new ErrorBean(errors.toString());
            request.setAttribute(FormBean.Attributes.ERROR_FORM_BEAN, errorBean);
            getServletContext().getRequestDispatcher(ERROR_URL).forward(request, response);
        }
    }
}
