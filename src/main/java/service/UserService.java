package service;

import dao.UserDAO;
import models.User;
import java.util.Optional;

public class UserService {

    private final UserDAO dao;

    public UserService() {
        this.dao = new UserDAO();
    }

    public void register(User user){
         dao.create(user);
    }

    public User getUser(int id) {
        return dao.get(id);
    }

    public Optional<User> login(String username, String password){
        return dao.getAll().stream().filter(u->
                        username.equals(u.getUsername()) &&
                        password.equals(u.getPassword())).findAny();
    }

    public boolean isUnique(String username) {
        return dao.getAll().stream().noneMatch(u -> username.equals(u.getUsername()));
    }
}
