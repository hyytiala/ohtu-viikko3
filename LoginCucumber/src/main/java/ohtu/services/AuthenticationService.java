package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        char[] p = password.toCharArray();
        int s = 0;
        int n = 0;
        if (username.length() < 3){
            return true;
        }
        if (password.length() < 8){
            return true;
        }
        for (int i = 0; i<p.length; i++){
            if (Character.isLetter(p[i])){
                
            }else if (Character.isDigit(p[i])){
                n++;
            }else{
                s++;
            }
        }
        if (s>0 || n>0){
            return false;
        }

        return true;
    }
}
