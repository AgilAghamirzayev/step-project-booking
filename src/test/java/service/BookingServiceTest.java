package service;

import models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    private BookingService service;
    private User user;
    private Passenger passenger3;
    private Flights flights;
    private Booking booking1;
    private Booking booking2;



    @BeforeEach
    public void setUp(){
        service = new BookingService();
        user = new User("Aqil","Zeka");
        Passenger passenger1 = new Passenger("Ali", "Aliyev");
        Passenger passenger2 = new Passenger("Zaur", "Hasanov");
        passenger3 = new Passenger("Ayxan","Memmedov");
        flights = new Flights(1, Airline.AZAL,Airport.KIEV,Airport.BAKU, LocalDateTime.of(2020, 3,16,16,12),30);
        booking1 = new Booking(user, passenger1,flights);
        booking2 = new Booking(user, passenger2,flights);

    }

    @Test
    void makeBooking() {
      service.makeBooking(booking1);
      service.makeBooking(booking2);
    }

    @Test
    void getBookingsByUser() {
        service.makeBooking(booking1);
        service.makeBooking(booking2);
        Booking booking3 = new Booking(user, passenger3, flights);
        service.makeBooking(booking3);
        assertEquals(3, service.getBookingsByUser(user).size());
        service.cancelBooking(3);
        assertEquals(2,service.getBookingsByUser(user).size());
    }

    @Test
    void cancelBooking() {
        service.makeBooking(booking1);
        service.makeBooking(booking2);
        List<Booking> bookings = service.getBookingsByUser(user);
        assertEquals(2, bookings.size());
        service.cancelBooking(1);
        service.cancelBooking(2);
    }
}