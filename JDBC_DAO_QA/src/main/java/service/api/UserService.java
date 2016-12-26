package service.api;

import domain.User;
import exception.UserExistException;
import exception.UserNotFoundException;

public interface UserService {

    User login(String login, String password) throws UserNotFoundException;
    User register(User user) throws UserExistException, UserNotFoundException;
    boolean isUserExist(String login);
}
