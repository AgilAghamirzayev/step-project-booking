package dao;

public class Write {

    public void write(){
        UserDAO userDAO = new UserDAO();
        FlightsDAO flightsDAO = new FlightsDAO();
        BookingDAO bookingDAO = new BookingDAO();
        userDAO.write();
        flightsDAO.write();
        bookingDAO.write();
    }
}
