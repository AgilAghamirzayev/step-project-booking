package controller;

import models.User;
import service.UserService;
import java.util.Optional;
import java.util.Scanner;

public class UserController  {

    private static Scanner scanner = new Scanner(System.in);
    private final UserService service;

    User user = new User();

    public UserController() {
        this.service = new UserService();
    }

    public User getUser() {
        return user;
    }


    public void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        while (!service.isUnique(username)){
            System.out.println("The user name already registered, Choose another username");
            username = scanner.nextLine();
        }
        user = new User(username, password);
        service.register(user);
        System.out.println("Registered successfully");
    }

    public boolean login()  {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Optional<User> users = service.login(username, password);
        if (users.isPresent()){
            user=users.get();
            return true;
        } else {
            System.out.println("No such user found. First register");
            return false;
        }
    }


}
