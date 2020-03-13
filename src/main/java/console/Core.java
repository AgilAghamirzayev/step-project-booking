package console;

import controller.BookingController;
import controller.FlightsController;
import controller.UserController;
import dao.FlightsDAO;
import models.*;
import service.FlightsService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Core{

    private static Scanner scanner = new Scanner(System.in);
    User user = new User();

    FlightsDAO flightsDAO = new FlightsDAO();
    FlightsService flightsService = new FlightsService(flightsDAO);
    FlightsController flightsController = new FlightsController(flightsService);
    UserController userController = new UserController();
    BookingController bookingController = new BookingController();

    public void login() throws InterruptedException, IOException, ClassNotFoundException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Optional<User> user = userController.login(username, password);
        Choose choose = new Choose();
        if (user.isPresent()){
            user.get();
            choose.booking_choose();
        } else {
            System.out.println("No such user found. First register");
            choose.user_choose();
        }
    }

    public void createNewAccount() throws InterruptedException, IOException, ClassNotFoundException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        while (!userController.isUnique(username)){
            System.out.println("The user name already registered, Choose another username");
            username = scanner.nextLine();
        }
        user = new User(username, password);
        userController.register(user);
        System.out.println("Registered successfully");
    }


    public void showTimetable() {
        System.out.println("===================================     TIMETABLE    =======================================");
        System.out.println("| ID|  |       AIRLINES       |  |  FLY FROM  |  |   FLY TO   |  |   DATE-TIME    |  |SEATS|");
        System.out.println("============================================================================================");
        flightsController.getAllFlights().forEach(System.out::println);
        System.out.println("============================================================================================");

    }

    public void searchFlight(){
        System.out.print("Enter origin (Ex: Baku) : ");
        String from = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter destination (Ex: Baku) : ");
        String to = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter date in 'yyyy-mm-dd' format (Ex: 2020-10-10) : " );
        String date = scanner.nextLine();


        if (flightsController.getAllFlights().stream()
                .filter(s -> s.getFrom().toString().equals(from) &&
                        s.getTo().toString().equals(to) &&
                        s.getDeparture().toLocalDate().toString().equals(date)).findAny().equals(Optional.empty())){
            System.out.println("There aren't available flight");
        } else {
            System.out.println("===================================     SEARCHING     ======================================");
            System.out.println("| ID|  |       AIRLINES       |  |  FLY FROM  |  |   FLY TO   |  |   DATE-TIME    |  |SEATS|");
            System.out.println("============================================================================================");

            flightsController.getAllFlights().stream()
                    .filter(s -> s.getFrom().toString().equals(from) &&
                            s.getTo().toString().equals(to) &&
                            s.getDeparture().toLocalDate().toString().equals(date))
                    .forEach(System.out::println);
            System.out.println("============================================================================================");

        }
    }


    public  void makeBooking(){
        System.out.println("======================     BOOKING     ======================");
        System.out.println();
        BookingController bookingController = new BookingController();
        System.out.print("Enter origin (Ex: Baku) : ");
        String from = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter destination (Ex: Baku) : ");
        String to = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter date in 'yyyy-mm-dd' format (Ex: 2020-10-10) : " );
        String date = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter airline: ");
        String airline = scanner.nextLine().toUpperCase().trim();
        System.out.print("Enter number of passengers: ");
        int numberOfPassengers=scanner.nextInt();

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
                bookingController.makeBooking(new Booking(this.user,new Passenger(fName,lName),flight));
            });
        }
    }


    public void showMyBooking(){
        System.out.println("==================================================================================================================================================================");
        System.out.println("|  ID   | |         Passengers           | |Flight: |ID |  |        AIRLINE       |  |    FROM    |  |     TO     |  |FLIGHT DATE-TIME|  |SEATS| |  BOOKING DATE  |");
        System.out.println("==================================================================================================================================================================");
        bookingController.getBookingsByUser(user).forEach(System.out::println);
        System.out.println("==================================================================================================================================================================");

    }

    public void cancelMyBooking(){
        System.out.print("Enter the id of booking: ");
        try {
            int id;
        List<Integer> ids = bookingController.getBookingsByUser(user).stream()
                .map(Booking::getId).collect(Collectors.toList());
        do {
            id = Integer.parseInt(scanner.nextLine().trim());
        } while (!ids.contains(id));
        bookingController.cancelBooking(id);
    } catch (Exception e){
            throw new IllegalArgumentException("Enter a valid ID");
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        Core core = new Core();
        core.createNewAccount();
        core.showTimetable();
        core.makeBooking();
        core.showMyBooking();
        core.cancelMyBooking();
        core.showMyBooking();
    }
}
