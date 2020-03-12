package console;

import controller.BookingController;
import controller.FlightsController;
import controller.UserController;
import dao.FlightsDAO;
import dao.UserDAO;
import models.*;
import service.BookingService;
import service.FlightsService;
import service.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Core {

    private static Scanner scanner = new Scanner(System.in);

    FlightsDAO flightsDAO = new FlightsDAO();
    UserDAO userDAO = new UserDAO();
    Booking booking =  new Booking();

    FlightsService flightsService = new FlightsService(flightsDAO);
    UserService userService = new UserService();
    BookingService bookingService = new BookingService();

    FlightsController flightsController = new FlightsController(flightsService);
    UserController userController = new UserController();
    BookingController bookingController = new BookingController();

    public void login() throws InterruptedException, IOException, ClassNotFoundException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userService.login(username, password);
    }

    public void createNewAccount(){
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userDAO.create(new User(username, password));
    }


    public void showTimetable() {
        flightsController.getAllFlights().stream().forEach(System.out::println);
    }

    public void searchFlight(){
        try {
            System.out.print("Enter descent  (e.x Baku): ");
            Airport from = Airport.valueOf(scanner.nextLine().toUpperCase().trim());
            System.out.print("Enter destination (e.x Baku): ");
            Airport to = Airport.valueOf(scanner.nextLine().toUpperCase().trim());
            System.out.print("Enter date (e.x yyyy-mm-dd): ");
            LocalDate localDate = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter number of passengers: ");
            int numOfPassenger = scanner.nextInt();
            System.out.println(flightsController.search(from,to,localDate,numOfPassenger));
        } catch (Exception e){
            System.out.println("Please enter valid  order");
            searchFlight();
        }
    }

    public void makeBooking(){
        System.out.print("Enter user: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String surname = scanner.nextLine();

        //Airline airline, Airport from, Airport to, LocalDateTime departure, List<Passenger> passengers, int size
        bookingController.makeBooking(new Booking());
    }

    public void showMyBooking(){
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        bookingController.getBookingsByUser(new User(username, password));

    }

    public void cancelMyBooking(){
        System.out.print("Enter booking id: ");
        int id = scanner.nextInt();
        bookingController.cancelBooking(id);
    }



}
