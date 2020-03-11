package menu;

public class BookingMenu implements Menu{
    @Override
    public String show() {
        String booking_menu =
                        "________________________________________\n" +
                        "|            Booking Menu               |\n" +
                        " ---------------------------------------\n" +
                        "| 1 -> Show Timetable                   |\n"+
                        "| 2 -> Search for a Flight              |\n"+
                        "| 3 -> Make a booking                   |\n"+
                        "| 4 -> Show my bookings                 |\n"+
                        "| 5 -> Cancel my booking                |\n"+
                        "| 6 -> Log Out                          |\n"+
                        "| 7 -> Exit                             |\n"+
                        "|_______________________________________|\n";

        return booking_menu;
    }
}
