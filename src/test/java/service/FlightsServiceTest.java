package service;

import dao.FlightsDAO;
import models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;

class FlightsServiceTest {

FlightsDAO dao = new FlightsDAO();

    FlightsService service ;
    private User user;
    private Passenger passenger3;
    private Flights flights;
    private Booking booking1;
    private Booking booking2;

    @BeforeEach
    public void setUp(){
        service = new FlightsService(dao);
        user = new User("Aqil","Zeka");
        Passenger passenger1 = new Passenger("Ali", "Aliyev");
        Passenger passenger2 = new Passenger("Zaur", "Hasanov");
        passenger3 = new Passenger("Ayxan","Memmedov");
        flights = new Flights(1, Airline.MANGO, Airport.KIEV,Airport.COLOMBIA, LocalDateTime.of(2020, 9,24,19,40),88);
        booking1 = new Booking(user, passenger1,flights);
        booking2 = new Booking(user, passenger2,flights);
    }


    @Test
    void getAllFlights() {

    }

    @Test
    void book() {
    }

    @Test
    void search() {
    }
}