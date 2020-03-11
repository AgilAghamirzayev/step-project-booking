package dao;

import models.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class UserDAO  {

    private final Map<Integer, User> users = new HashMap<>();
    private File file = new File("userfile.txt");

    public Map<Integer, User> getUsers() {
        return users;
    }



}
