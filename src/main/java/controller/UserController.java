package controller;

import models.User;
import service.UserService;

import java.io.IOException;
import java.util.Optional;

public class UserController  {

    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    public UserController() {
        this.service = new UserService();
    }

    public User getUser(int id) {
        return service.getUser(id);
    }

    public boolean isUnique(String username) throws InterruptedException, IOException, ClassNotFoundException {
        return service.isUnique(username);
    }

    public void register(User user) {
         service.register(user);
    }

    public Optional<User> login(String username, String password) throws InterruptedException, IOException, ClassNotFoundException {
        return service.login(username, password);
    }

    public boolean logout(User user) {
        return service.logout(user);
    }

}
