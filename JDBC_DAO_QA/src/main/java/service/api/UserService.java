package service.api;

import domain.User;
import exception.UserExistException;

public interface UserService {

    User login(String login, String password);
    User register(User user) throws UserExistException;
    boolean isUserExist(String login);
}
