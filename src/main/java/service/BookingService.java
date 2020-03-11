package service;

import dao.BookingDAO;



public class BookingService  {

    private BookingDAO bookingDAO;


    public boolean isFlightExist(int flight_id){
        try {
            return true;
        } catch (RuntimeException e){
            return false;
        }
    }



}
