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
        return users;
    }

    @Override
    public void create(User user) {
        users.add(user.getId(), user);
        write();
    }

    @Override
    public void delete(int id) {
        users.remove(id);
        write();
    }

    @Override
    public void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            oos.writeObject(getAll().toArray());
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void read() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            users = (List<User>) ois.readObject();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
