package dao;

import models.Booking;
import models.User;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class BookingDAO implements DAO<Booking>{

    private  Map<Integer, User> books = new HashMap<>();
    private File file = new File("booksFile.txt");

    public Map<Integer, User> getBooks() {
        return books;
    }


    @Override
    public Booking get(int id) {
        return null;
    }

    @Override
    public Collection<Booking> getAll() throws IOException, ClassNotFoundException, InterruptedException {
        return null;
    }

    @Override
    public void create(Booking data) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void write() {

    }

    @Override
    public void read() {

    }
}
