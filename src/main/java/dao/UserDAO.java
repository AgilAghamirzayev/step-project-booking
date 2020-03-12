package dao;

import models.Flights;
import models.User;
import java.io.*;
import java.util.*;


public class UserDAO  implements DAO<User>{

    private List<User> users = new LinkedList<>();
    private File file = new File("userFile.txt");

    public List<User> getUsers() {
        return users;
    }


    @Override
    public User get(int id)  {
        User user = users.get(id);
        return user;
    }

    @Override
    public Collection<User> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream( new BufferedInputStream(new FileInputStream(file)))) {
           return (List<User>) ois.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void create(User user) {
        users.add(user);
        write();
    }

    @Override
    public void delete(int id) {
        users.remove(id-1);
        write();
    }

    @Override
    public void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            oos.writeObject(users);
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void read() {
    }

//    public static void main(String[] args) {
//        UserDAO userDAO = new UserDAO();
//        userDAO.create(new User("Aqil","Zeka"));
//        userDAO.create(new User("Ali","12345"));
//        userDAO.create(new User("Zeyneb","AliAli"));
//        userDAO.getAll().forEach(System.out::println);
//        System.out.println("_______________________________________");
//        userDAO.getUsers().forEach(System.out::println);
//        System.out.println("_______________________________________");
//        userDAO.delete(1);
//        userDAO.getUsers().forEach(System.out::println);
//    }

}
