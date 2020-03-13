package dao;

import models.Flights;
import models.User;
import java.io.*;
import java.util.*;


public class UserDAO  implements DAO<User>{

    private List<User> users = new LinkedList<>();
    private File file = new File("userFile.txt");


    @Override
    public User get(int id)  {
        return users.get(id);
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
        users.removeIf(user -> user.getId()==id);
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


}
