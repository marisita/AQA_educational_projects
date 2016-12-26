package converter;

import constants.FormBean;
import domain.User;
import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import servlet.bean.UserBean;

import javax.servlet.http.HttpServletRequest;

import static utils.TestData.*;

public class UserConverterTest {

    private UserConverter userConverter;
    private HttpServletRequest httpServletRequest;
    private User user;
    private UserBean userBean;
    private UserBean userBeanOutput;

    @BeforeMethod
    public void setUp() throws Exception {

        userConverter = new UserConverter();
        httpServletRequest = EasyMock.createMock(HttpServletRequest.class);
        user = TEST_USER;
        userBean = TEST_USER_BEAN_VALID;
        userBeanOutput = TEST_USER_BEAN_OUTPUT;
    }

    @Test
    public void testConvertFromRequestToUserBean() throws Exception {

        EasyMock.expect(httpServletRequest.getParameter(FormBean.RegisterParameters.LOGIN)).andReturn(userBean.getLogin());
        EasyMock.expect(httpServletRequest.getParameter(FormBean.RegisterParameters.PASSWORD)).andReturn(userBean.getPassword());
        EasyMock.expect(httpServletRequest.getParameter(FormBean.RegisterParameters.REPEATED_PASSWORD)).andReturn(userBean.getRepeatedPassword());
        EasyMock.expect(httpServletRequest.getParameter(FormBean.RegisterParameters.FIRST_NAME)).andReturn(userBean.getFirstName());
        EasyMock.expect(httpServletRequest.getParameter(FormBean.RegisterParameters.LAST_NAME)).andReturn(userBean.getLastName());
        EasyMock.expect(httpServletRequest.getParameter(FormBean.RegisterParameters.EMAIL)).andReturn(userBean.getEmail());
        EasyMock.expect(httpServletRequest.getParameter(FormBean.RegisterParameters.SEX)).andReturn(userBean.getSex());
        EasyMock.replay(httpServletRequest);

        UserBean userBeanConverted = userConverter.convert(httpServletRequest);
        Assert.assertEquals(userBeanConverted, userBean);
    }

    @Test
    public void testConvertFromUserToUserBean() throws Exception {

        UserBean userBeanConverted = userConverter.convert(user);
        Assert.assertEquals(userBeanConverted, userBeanOutput);
    }

    @Test
    public void testConvertFromUserBeanToUser() throws Exception {

        User userConverted = userConverter.convert(userBean);
        Assert.assertEquals(userConverted, user);

    }

}