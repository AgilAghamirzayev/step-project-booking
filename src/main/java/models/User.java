package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int counter=1;
    private  int id;
    private  String username;
    private  String password;
    private  List<Booking> bookings;


    public User(String username, String password) {
        this.id = counter++;
        this.username = username;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public User(){
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    void addBooking(Booking booking){
        bookings.add(booking);
    }

    @Override
    public String toString() {
        return String.format("ID: %d Username: %s Password: %s", id, username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id==user.id &&
                username.equals(user.username) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
