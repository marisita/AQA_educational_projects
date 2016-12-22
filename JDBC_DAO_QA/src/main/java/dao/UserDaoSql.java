package dao;

import dao.api.UserDao;
import domain.User;
import exception.DBException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class UserDaoSql implements UserDao {

    private DataSource dataSource;

    private static final java.lang.String LOGIN_USER = "SELECT * FROM user WHERE login=? AND password=?";
    private static final java.lang.String REGISTER_USER = "INSERT INTO `users`.`user` (`login`, `password`, `firstName`, `lastName`, `email`, `sex`) VALUES (?, ?, ?, ?, ?, ?);";
    private static final java.lang.String IS_USER_EXIST = "SELECT * FROM user WHERE login=?";
    private static final java.lang.String GET_USERS = "SELECT * FROM user";

    public UserDaoSql(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User login(String login, String password) throws DBException {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(LOGIN_USER)) {

            pstmt.setString(1, login);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setEmail(resultSet.getString("email"));
                user.setSex(resultSet.getString("sex"));
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
             PreparedStatement pstmt = connection.prepareStatement(REGISTER_USER)) {

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
        PreparedStatement pstmt = connection.prepareStatement(IS_USER_EXIST)) {

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

    @Override
    public HashMap<String, User> getUsers() throws DBException {

        HashMap<String, User> users = new HashMap<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(GET_USERS)) {

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setEmail(resultSet.getString("email"));
                user.setSex(resultSet.getString("sex"));;
                users.put(String.valueOf(user.getId()), user);
            }
            resultSet.close();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

        return users;
    }
}
