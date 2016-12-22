package dao.api;

import domain.User;
import exception.DBException;

import java.util.HashMap;

public interface UserDao {

    User login(String login, String password) throws DBException;
    User register(User user) throws DBException;
    boolean isUserExist(String login) throws DBException;
    HashMap<String, User> getUsers() throws DBException;
}
