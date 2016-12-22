package service.api;

import domain.User;
import exception.UserExistException;

import java.util.HashMap;

public interface UserService {

    User login(String login, String password);
    User register(User user) throws UserExistException;
    boolean isUserExist(String login);
    HashMap<String, User> getUsers();
}
