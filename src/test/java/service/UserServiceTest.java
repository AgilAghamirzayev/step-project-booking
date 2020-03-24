package service;

import dao.UserDAO;
import models.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    UserService service;
    UserDAO dao;
    User user;

    @BeforeEach
    void setUp(){
        new UserService();
        new UserDAO();
        new User("A","A");
    }

    @Test
    void register() {
    }

    @Test
    void login() {

    }

    @Test
    void isUnique() {
    }
}