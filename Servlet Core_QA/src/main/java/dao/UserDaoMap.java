package dao;

import dao.api.UserDao;
import db.Users;
import domain.User;
import exception.DBException;

import java.util.HashMap;

import static constants.ExceptionMessage.*;

public class UserDaoMap implements UserDao {

    @Override
    public User login(String login, String password) throws DBException {

        try {
            return Users.getUser(login, password);
        } catch (Exception e) {
            throw new DBException(CANNON_LOGIN_USER, e);
        }
    }

    @Override
    public User register(User user) throws DBException {

        try {
            return Users.addUser(user);
        } catch (Exception e) {
            throw new DBException(CANNON_INSERT_USER, e);
        }
    }

    @Override
    public boolean isUserExist(String login) throws DBException {

        try {
            return Users.isUserExists(login);
        } catch (Exception e) {
            throw new DBException(CANNOT_GET_USER, e);
        }
    }

    @Override
    public HashMap<String, User> getUsers() throws DBException {
        try {
            return Users.getUsers();
        } catch (Exception e) {
            throw new DBException(CANNOT_GET_USERS, e);
        }
    }
}
