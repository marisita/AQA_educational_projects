package db;

import domain.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Users {

    private static HashMap<String, User> users = new HashMap<>();

    public static User getUser(String login, String password) {

        User user = users.get(login);

        if (password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public static HashMap<String, User> getUsers(){
        return users;
    }

    public static User addUser(User user) {
        users.put(user.getLogin(), user);
        return users.get(user.getLogin());
    }

    public static boolean isUserExists(String newLogin) {

        List<String> logins = new LinkedList<>(users.keySet());

        for (String login: logins) {
            if (newLogin.equals(login)) {
               return true;
            }
        }
        return false;
    }
}