package listener;

import dao.UserDaoSql;
import dao.api.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import property.PropertyFactory;
import service.UserServiceImpl;
import service.api.UserService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import static constants.LoggerInfoMessage.CONTEXT_DESTROYED;
import static constants.LoggerInfoMessage.CONTEXT_STARTED;
import static constants.MyAttribute.MyServletContextListener.*;

public class MyServletContextListener implements ServletContextListener {

    private static final Logger LOGGER = LogManager.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {
            PropertyFactory.getInstance();
            DataSource dataSource = (DataSource)new InitialContext().lookup(PropertyFactory.getProperty("dataSourcePath"));
            UserDao userDao = new UserDaoSql(dataSource);

            servletContextEvent.getServletContext().setAttribute(USER_DAO, userDao);
            UserService userService = new UserServiceImpl(userDao);

            ServletContext servletContext = servletContextEvent.getServletContext();
            servletContext.setAttribute(USER_SERVICE, userService);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }


        LOGGER.info(CONTEXT_STARTED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info(CONTEXT_DESTROYED);
    }
}
