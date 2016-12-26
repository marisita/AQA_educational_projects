package service;

import dao.api.UserDao;
import domain.User;
import exception.DBException;
import exception.UserExistException;
import exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.api.UserService;

import static constants.ExceptionMessage.*;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String login, String password) throws UserNotFoundException {

        User user = null;

        try {
            user = userDao.login(login, password);
        } catch (DBException e) {
            LOGGER.error(e.getMessage());
        }

        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException(INVALID_LOGIN_OR_PASSWORD);
        }
    }

    @Override
    public synchronized User register(User user) throws UserExistException, UserNotFoundException {

        User registeredUser = null;

        if (isUserExist(user.getLogin())) {
            throw new UserExistException(USER_WITH_THIS_LOGIN_EXIST);
        } else {
            try {
                registeredUser = userDao.register(user);
            } catch (DBException e) {
                LOGGER.error(e.getMessage());
            }
        }

        if (registeredUser != null) {
            return registeredUser;
        } else {
            throw new UserNotFoundException(CANNON_INSERT_USER);
        }
    }

    @Override
    public boolean isUserExist(String login) {

        boolean isExist = false;

        try {
            isExist = userDao.isUserExist(login);
        } catch (DBException e) {
            LOGGER.error(e.getMessage());
        }

        return isExist;
    }
}
