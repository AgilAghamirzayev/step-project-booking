package dao;

import models.*;

import java.io.*;
import java.util.*;

public class BookingDAO implements DAO<Booking>{

    private  List<Booking> books = new LinkedList<>();
    private File file = new File("booksFile.txt");


    @Override
    public Booking get(int id) {
        return books.get(id);
    }

    @Override
    public Collection<Booking> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream( new BufferedInputStream(new FileInputStream(file)))) {
            return (List<Booking>) ois.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void create(Booking data) {
        if (data!=null || !(books.contains(data))){
            books.add(data);
        }
    }

    @Override
    public void delete(int id) {
        books.removeIf(booking -> id==booking.getId());
    }

    @Override
    public void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            oos.writeObject(books);
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void read() {

    }

//    public static void main(String[] args) {
//        BookingDAO bookingDAO = new BookingDAO();
//        UserDAO userDAO = new UserDAO();
//        User user = new User("Aqil","12345");
//        userDAO.create(user);
//        bookingDAO.create(new Booking(user, new Passenger("Ali","Muradli"),new Flights(1)));
//        bookingDAO.getAll().forEach(System.out::println);
//    }
}
