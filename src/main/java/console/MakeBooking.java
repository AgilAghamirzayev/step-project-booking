package console;

import controller.BookingController;
import controller.FlightsController;
import dao.FlightsDAO;
import models.Booking;
import models.Flights;
import models.Passenger;
import models.User;
import service.FlightsService;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MakeBooking {
   static Scanner  scanner = new Scanner(System.in);
   static FlightsDAO flightsDAO = new FlightsDAO();
   static FlightsService flightsService = new FlightsService(flightsDAO);
   static FlightsController flightsController = new FlightsController(flightsService);
   static User user = new User("Aqil", "Zeka");

static     BookingController bookingController = new BookingController();

    public static void makeBooking(){

        int numberOfPassengers;
        System.out.print("Enter origin (Ex: Baku) : ");
        String from = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter destination (Ex: Baku) : ");
        String to = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter date in 'yyyy-mm-dd' format (Ex: 2020-10-10) : " );
        String date = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter airline: ");
        String airline = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter number of passengers: ");
        numberOfPassengers=scanner.nextInt();

        if (flightsController.getAllFlights().stream()
                .filter(s -> s.getFrom().toString().equals(from) &&
                        s.getTo().toString().equals(to) &&
                        s.getDeparture().toLocalDate().toString().equals(date)&&
                        s.getAirline().toString().equals(airline)).findAny().equals(Optional.empty())){
            System.out.println("There aren't available flight. Try again...");
            makeBooking();
        }
        else {
            Flights flight  = flightsController.getAllFlights().stream()
                    .filter(s -> s.getFrom().toString().equals(from) &&
                            s.getTo().toString().equals(to) &&
                            s.getDeparture().toLocalDate().toString().equals(date)&&
                            s.getAirline().toString().equals(airline)).findAny().get();
        IntStream.range(1,numberOfPassengers+1).forEach(n-> {
            System.out.print("Enter first name of passenger: " + n + ": ");
            String fName = scanner.nextLine();
            System.out.print("Enter last name of passenger: " + n + ": ");
            String lName = scanner.nextLine();
            bookingController.makeBooking(new Booking(user,new Passenger(fName,lName),flight));
        });
    }
    }

    public static void main(String[] args) {
        FlightsDAO flightsDAO = new FlightsDAO();
        FlightsService flightsService = new FlightsService(flightsDAO);
        FlightsController flightsController = new FlightsController(flightsService);
        flightsController.getAllFlights().forEach(System.out::println);
        makeBooking();
        System.out.println("==================================================================================================================================================================");
        System.out.println("|  ID   | |         Passengers           | |Flight: |ID |  |        AIRLINE       |  |    FROM    |  |     TO     |  |FLIGHT DATE-TIME|  |SEATS| |  BOOKING DATE  |");
        System.out.println("==================================================================================================================================================================");
        bookingController.getBookingsByUser(user).forEach(System.out::println);
        System.out.println("==================================================================================================================================================================");

    }
}
