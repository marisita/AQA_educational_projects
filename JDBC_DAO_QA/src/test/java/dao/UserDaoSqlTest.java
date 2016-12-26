package dao;

import dao.api.UserDao;
import domain.User;
import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static constants.SQLAttribute.SQLColumnName.*;
import static constants.SQLAttribute.SQLStatement.*;
import static utils.TestData.*;

public class UserDaoSqlTest {

    private DataSource dataSource;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private UserDao userDao;
    private User user;

    @BeforeMethod
    public void setUp() throws Exception {
        dataSource = EasyMock.createMock(DataSource.class);
        connection = EasyMock.createMock(Connection.class);
        preparedStatement = EasyMock.createMock(PreparedStatement.class);
        resultSet = EasyMock.createMock(ResultSet.class);
        userDao = new UserDaoSql(dataSource);
        user = TEST_USER;
    }

    @Test
    public void testLogin() throws Exception {

        getConnection();
        getPreparedStatement(LOGIN_USER_STATEMENT);

        preparedStatement.setString(1, TEST_LOGIN);
        EasyMock.expectLastCall();
        preparedStatement.setString(2, TEST_PASSWORD);
        EasyMock.expectLastCall();

        executeQueryPreparedStatement();

        EasyMock.expect(resultSet.next()).andReturn(true);
        EasyMock.expect(resultSet.getInt(ID_COLUMN)).andReturn(0);
        EasyMock.expect(resultSet.getString(LOGIN_COLUMN)).andReturn("anna");
        EasyMock.expect(resultSet.getString(PASSWORD_COLUMN)).andReturn("anna123");
        EasyMock.expect(resultSet.getString(FIRST_NAME_COLUMN)).andReturn("anna");
        EasyMock.expect(resultSet.getString(LAST_NAME_COLUMN)).andReturn("red");
        EasyMock.expect(resultSet.getString(EMAIL_COLUMN)).andReturn("anna@gmail.com");
        EasyMock.expect(resultSet.getString(SEX_COLUMN)).andReturn("female");

        closeResource(resultSet);
        closeResource(preparedStatement);
        closeResource(connection);

        User loggedUser = userDao.login(TEST_LOGIN, TEST_PASSWORD);
        Assert.assertEquals(loggedUser, user);
    }


    @Test
    public void testRegister() throws Exception {

        getConnection();
        getPreparedStatement(REGISTER_USER_STATEMENT);

        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getLastName());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getSex());
        EasyMock.expectLastCall();

        executeUpdatePreparedStatement();

        closeResource(preparedStatement);
        closeResource(connection);

        User registeredUser = userDao.register(user);
        Assert.assertEquals(registeredUser, user);

    }

    @Test
    public void testIsUserExist() throws Exception {

        getConnection();
        getPreparedStatement(IS_USER_EXIST_STATEMENT);

        preparedStatement.setString(1, TEST_LOGIN);
        EasyMock.expectLastCall();

        executeQueryPreparedStatement();

        EasyMock.expect(resultSet.next()).andReturn(false);

        closeResource(resultSet);
        closeResource(preparedStatement);
        closeResource(connection);

        boolean isUserExist = userDao.isUserExist(TEST_LOGIN);
        Assert.assertEquals(isUserExist, false);
    }

    private void getConnection() throws SQLException {
        EasyMock.expect(dataSource.getConnection()).andReturn(connection);
        EasyMock.replay(dataSource);
    }

    private void getPreparedStatement(String statement) throws SQLException {
        EasyMock.expect(connection.prepareStatement(statement)).andReturn(preparedStatement);
    }

    private void executeQueryPreparedStatement() throws SQLException {
        EasyMock.expect(preparedStatement.executeQuery()).andReturn(resultSet);
    }

    private void executeUpdatePreparedStatement() throws SQLException {
        EasyMock.expect(preparedStatement.executeUpdate()).andReturn(1);
    }

    private void closeResource(AutoCloseable resource) throws Exception {
        resource.close();
        EasyMock.expectLastCall();
        EasyMock.replay(resource);
    }

}