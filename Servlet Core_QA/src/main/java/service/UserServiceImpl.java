package service;

import dao.api.UserDao;
import domain.User;
import exception.DBException;
import exception.UserExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.api.UserService;

import java.util.HashMap;

import static constants.ExceptionMessage.USER_WITH_THIS_LOGIN_EXIST;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String login, String password) {

        User user = null;

        try {
            user = userDao.login(login, password);
        } catch (DBException e) {
            LOGGER.error(e.getMessage());
        }

        return user;
    }

    @Override
    public synchronized User register(User user) throws UserExistException {

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
        return registeredUser;
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

    @Override
    public HashMap<String, User> getUsers(){

        HashMap<String, User> users = null;

        try {
            users = userDao.getUsers();
        } catch (DBException e) {
            LOGGER.error(e.getMessage());
        }

        return users;
    }


}
