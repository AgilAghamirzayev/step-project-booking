package console;

import controller.FlightsController;
import controller.UserController;
import dao.FlightsDAO;
import dao.UserDAO;
import models.Airport;
import models.User;
import service.FlightsService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Core {

    private static Scanner scanner = new Scanner(System.in);

    FlightsDAO flightsDAO = new FlightsDAO();
    FlightsService flightsService = new FlightsService(flightsDAO);
    FlightsController flightsController = new FlightsController(flightsService);

    UserController userController = new UserController();

    public void login() throws InterruptedException, IOException, ClassNotFoundException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userController.login(username, password);
    }

    public void createNewAccount(){
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userController.register(new User(username,password));
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
            System.out.print("Enter date (e.x dd.MM.yyyy): ");
            LocalDate localDate = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
            System.out.print("Enter number of passengers: ");
            int numOfPassenger = scanner.nextInt();
            System.out.println(flightsController.search(from,to,localDate,numOfPassenger));
        } catch (Exception e){
            System.out.println("Please enter valid  order");
            searchFlight();
        }
    }

    public void makeBooking(){

    }

    public void showMyBooking(){

    }

    public void cancelMyBooking(){

    }

    public void logOut(){
    }



}
