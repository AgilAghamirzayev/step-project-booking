package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Booking implements Serializable {

    private static int counter = 1;

    private int id;
    private User user;
    private Flights flights;
    private Passenger passengers;
    private LocalDateTime booked;

    public Booking(User user,  Passenger passenger, Flights flights) {
        this.id = counter++;
        this.booked = LocalDateTime.now();
        this.user = user;
        this.flights = flights;
        this.flights.addPassenger(passenger);
        this.user.addBooking(this);
    }

    public Booking(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flights getFlights() {
        return flights;
    }

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    public Passenger getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
//        return "ID: " + id + " Fly From " +  + " to the " + flights.getToCity().getName() + " on day: " + flights.getTime() +
//                " there are only " + passengers.size() + " seats " ;

        return String.format("ID: %d Passenger: %s Flight: %s", id, passengers.toString(), flights );
    }
}


