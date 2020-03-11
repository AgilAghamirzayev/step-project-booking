package dao;

import models.Booking;
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
        return books;
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
            oos.writeObject(getAll().toArray());
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void read() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            books = (List<Booking>) ois.readObject();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
