package dao;

import dao.api.UserDao;
import domain.User;
import exception.DBException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static constants.SQLAttribute.SQLColumnName.*;
import static constants.SQLAttribute.SQLStatements.*;

public class UserDaoSql implements UserDao {

    private DataSource dataSource;

    public UserDaoSql(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User login(String login, String password) throws DBException {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(LOGIN_USER_STATEMENT)) {

            pstmt.setString(1, login);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(ID_COLUMN));
                user.setLogin(resultSet.getString(LOGIN_COLUMN));
                user.setPassword(resultSet.getString(PASSWORD_COLUMN));
                user.setFirstName(resultSet.getString(FIRST_NAME_COLUMN));
                user.setLastName(resultSet.getString(LAST_NAME_COLUMN));
                user.setEmail(resultSet.getString(EMAIL_COLUMN));
                user.setSex(resultSet.getString(SEX_COLUMN));
                resultSet.close();
                return user;
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return null;
    }

    @Override
    public User register(User user) throws DBException {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(REGISTER_USER_STATEMENT)) {

            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getSex());

            int registeredUserId = pstmt.executeUpdate();

            if (registeredUserId > 0) {
                return user;
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean isUserExist(String login) throws DBException {

        try (Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(IS_USER_EXIST_STATEMENT)) {

            pstmt.setString(1, login);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

        return false;
    }
}
