package servlet;

import domain.User;
import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.UserServiceImpl;
import service.api.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import static constants.MyAttribute.MyServletContextListener.USER_SERVICE;
import static utils.TestData.TEST_USER;

public class RegisterServletTest {

    private HttpServletRequest httpServletRequest;
    private ServletContext servletContext;
    private UserService userService;
    private User user;

    @BeforeTest
    public void setUp() throws Exception {
        httpServletRequest = EasyMock.createMock(HttpServletRequest.class);
        servletContext = EasyMock.createMock(ServletContext.class);
        userService = EasyMock.createMock(UserServiceImpl.class);
        user = TEST_USER;
    }

    @Test
    public void testDoPost() throws Exception {

        EasyMock.expect(httpServletRequest.getServletContext()).andReturn(servletContext);
        EasyMock.replay(httpServletRequest);
        servletContext = httpServletRequest.getServletContext();
        servletContext.setAttribute(USER_SERVICE, userService);

        EasyMock.expect(servletContext.getAttribute(USER_SERVICE)).andReturn(userService);
        EasyMock.replay(servletContext);
        userService = (UserServiceImpl) servletContext.getAttribute(USER_SERVICE);

        EasyMock.expect(userService.register(user)).andReturn(user);
        EasyMock.replay(userService);
        User registeredUser = userService.register(user);

        Assert.assertEquals(registeredUser, user);
    }
}