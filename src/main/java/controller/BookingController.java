package controller;

import models.Booking;
import models.User;
import service.BookingService;
import java.util.List;

public class BookingController  {

    private final BookingService service;

    public BookingController() {
        this.service = new BookingService();
    }


    public void makeBooking(Booking booking) {
         service.makeBooking(booking);
    }

    public List<Booking> getBookingsByUser(User user) {
        return service.getBookingsByUser(user);
    }

    public void cancelBooking(int id) {
         service.cancelBooking(id);
    }

}
