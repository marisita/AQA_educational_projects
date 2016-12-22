package listener;

import constants.MyAttribute;
import dao.UserDaoMap;
import dao.api.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.UserServiceImpl;
import service.api.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static constants.LoggerInfoMessage.*;

public class MyServletContextListener implements ServletContextListener {

    private static final Logger LOGGER = LogManager.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        UserDao userDao = new UserDaoMap();
        UserService userService = new UserServiceImpl(userDao);

        ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute(MyAttribute.MyServletContextListener.USER_SERVICE, userService);
        LOGGER.info(CONTEXT_STARTED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info(CONTEXT_DESTROYED);
    }
}
