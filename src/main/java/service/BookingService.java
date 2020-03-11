package service;

import dao.BookingDAO;
import models.Booking;
import models.User;

import java.util.List;
import java.util.stream.Collectors;


public class BookingService  {

    private final BookingDAO dao;

    public BookingService() {
        this.dao = new BookingDAO();
    }

    public void makeBooking(Booking booking) {
         dao.create(booking);
    }

    public List<Booking> getBookingsByUser(User user) {
        return dao.getAll().stream()
                .filter(booking -> booking.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public void cancelBooking(int id) {
         dao.delete(id);
    }
}
