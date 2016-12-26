package servlet;

import constants.FormBean;
import constants.MyAttribute;
import converter.UserConverter;
import domain.User;
import exception.UserExistException;
import exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import property.PropertyFactory;
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

        UserConverter userConverter = new UserConverter();
        UserBean userBean = userConverter.convert(request);
        LOGGER.info(USER_WAS_CONVERTED_FROM_REQUEST + userBean);

        RegisterValidator registerValidator = new RegisterValidator();
        errors.addAll(registerValidator.validate(userBean));

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            ErrorBean errorBean = new ErrorBean(errors.toString());
            request.setAttribute(FormBean.Attributes.ERROR_FORM_BEAN, errorBean);
            getServletContext().getRequestDispatcher(PropertyFactory.getProperty("errorUrl")).forward(request, response);
            return;
        }

        User user = userConverter.convert(userBean);
        LOGGER.info(USER_WAS_CONVERTED_FROM_BEAN + user);

        try {
            User registeredUser = userService.register(user);
            LOGGER.info(USER_WAS_REGISTERED + registeredUser);
            request.setAttribute(FormBean.Attributes.REGISTER_FORM_BEAN, userBean);
            getServletContext().getRequestDispatcher(PropertyFactory.getProperty("registerSuccessfullyUrl")).forward(request, response);
        } catch (UserExistException | UserNotFoundException e) {
            errors.add(e.getMessage());
            LOGGER.error(errors);
            ErrorBean errorBean = new ErrorBean(errors.toString());
            request.setAttribute(FormBean.Attributes.ERROR_FORM_BEAN, errorBean);
            getServletContext().getRequestDispatcher(PropertyFactory.getProperty("errorUrl")).forward(request, response);
        }
    }
}
