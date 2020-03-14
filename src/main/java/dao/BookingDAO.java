package dao;

import models.*;

import java.io.*;
import java.util.*;
public class BookingDAO implements DAO<Booking>{

    private  List<Booking> books = new LinkedList<>();
    private File file = new File("booksFile.txt");

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
    public void create(Booking book) {
        books.add(book);
        write();
    }

    @Override
    public void delete(int id) {
        books.removeIf(booking -> id==booking.getId());
        write();
    }

    @Override
    public void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            oos.writeObject(books);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
