package models;

import java.io.Serializable;
import java.time.LocalDate;
public class Booking implements Serializable {


    private static final long serialVersionUID = 1L;
    private static int counter = 1;

    private int id;
    private User user;
    private Flights flights;
    private Passenger passengers;
    private LocalDate booked;

    public Booking(User user, Passenger passenger, Flights flights) {
        this.id = counter++;
        this.booked = LocalDate.now();
        this.user = user;
        this.passengers=passenger;
        this.flights = flights;
        this.flights.addPassenger(passenger);
        this.user.addBooking(this);
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
        return String.format("|ID: %02d | |Passenger: %9s %9s| |Flight: %s |Date: %s|", id, passengers.getFirstName().toUpperCase(), passengers.getLastName().toUpperCase(), flights, booked );
    }
}


