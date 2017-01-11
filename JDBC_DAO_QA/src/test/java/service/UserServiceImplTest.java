package service;

import dao.api.UserDao;
import domain.User;
import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.api.UserService;

import static utils.TestData.*;

public class UserServiceImplTest {

    private UserDao userDao;
    private UserService userService;
    private User user;

    @BeforeMethod
    public void setUp() throws Exception {
        userDao = EasyMock.createMock(UserDao.class);
        userService = new UserServiceImpl(userDao);
        user = TEST_USER;
    }

    @Test
    public void testLogin() throws Exception {
        EasyMock.expect(userDao.login(user.getLogin(), user.getPassword())).andReturn(user);
        EasyMock.replay(userDao);
        User loggedUser = userService.login(user.getLogin(), user.getPassword());
        Assert.assertEquals(loggedUser, user);
    }

    @Test
    public void testRegister() throws Exception {
        EasyMock.expect(userDao.isUserExist(user.getLogin())).andReturn(false);
        EasyMock.expect(userDao.register(user)).andReturn(user);
        EasyMock.replay(userDao);
        User registeredUser = userService.register(user);
        Assert.assertEquals(registeredUser, user);
    }

    @Test
    public void testIsUserExist() throws Exception {
        EasyMock.expect(userDao.isUserExist(user.getLogin())).andReturn(true);
        EasyMock.replay(userDao);
        Assert.assertEquals(userService.isUserExist(user.getLogin()), true);
    }
}