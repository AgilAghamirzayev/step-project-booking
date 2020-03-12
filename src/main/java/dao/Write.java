package dao;

public class Write {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        FlightsDAO flightsDAO = new FlightsDAO();
        BookingDAO bookingDAO = new BookingDAO();
        userDAO.write();
        flightsDAO.write();
        bookingDAO.write();
    }

}
