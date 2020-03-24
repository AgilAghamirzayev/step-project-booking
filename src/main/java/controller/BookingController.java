package controller;

import models.Booking;
import models.Flights;
import models.Passenger;
import service.BookingService;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookingController  {

    private final BookingService service;
    private final FlightsController flightsController;
    private final UserController userController;
    private static Scanner scanner = new Scanner(System.in);

    public BookingController(FlightsController flightsController, UserController userController) {
        this.flightsController = flightsController;
        this.userController = userController;
        this.service = new BookingService();
    }


    public void makeBooking() {
        try {
            System.out.println("======================     BOOKING     ======================");
            System.out.println();
            System.out.print("Enter origin (Ex: Baku) : ");
            String from = scanner.nextLine().toUpperCase().trim();
            System.out.print("Enter destination (Ex: Baku) : ");
            String to = scanner.nextLine().toUpperCase().trim();
            System.out.print("Enter date in 'yyyy-mm-dd' format (Ex: 2020-10-10) : ");
            String date = scanner.nextLine().toUpperCase().trim();
            System.out.print("Enter airline: ");
            String airline = scanner.nextLine().toUpperCase().trim();
            System.out.println("Enter id of flights");
            int numberOfPassengers = Integer.parseInt(scanner.nextLine());
            if (flightsController.book(from, to, date, airline, numberOfPassengers).isEmpty()) {
                System.out.println("There aren't available flight. Try again...");
                makeBooking();
            } else {
                Flights flight = flightsController.book(from, to, date, airline, numberOfPassengers).stream().findAny().get();
                IntStream.range(1, numberOfPassengers + 1).forEach(n -> {
                    System.out.println("=====================   ADD PASSENGER(S)  =======================");
                    System.out.print("Enter first name of passenger: " + n + ": ");
                    String fName = scanner.nextLine();
                    System.out.print("Enter last name of passenger: " + n + ": ");
                    String lName = scanner.nextLine();
                    service.makeBooking(new Booking(userController.getUser(), new Passenger(fName, lName), flight));
                });
            }
        }catch (NumberFormatException e){
            System.out.println("Write a valid number of person!!!");
            makeBooking();
        }
    }


    public void showMyBooking(){
        if (!service.getBookingsByUser(userController.getUser()).isEmpty()) {
            System.out.println("==================================================================================================================================================================");
            System.out.println("|  ID   | |         Passengers           | |Flight: |ID |  |        AIRLINE       |  |    FROM    |  |     TO     |  |FLIGHT DATE-TIME|  |SEATS| |  BOOKING DATE  |");
            System.out.println("==================================================================================================================================================================");
            service.getBookingsByUser(userController.getUser()).forEach(System.out::println);
            System.out.println("==================================================================================================================================================================");
        } else {
            System.out.println("Your booking(s) is empty");
        }
    }

    public void cancelBooking() {
        System.out.print("Enter the id of booking: ");
        int id = 0;
        try {
            List<Integer> ids = service.getBookingsByUser(userController.getUser()).stream()
                    .map(Booking::getId).collect(Collectors.toList());
            if (!ids.isEmpty()) {
                do {
                    id = Integer.parseInt(scanner.nextLine());
                } while (!ids.contains(id));
                service.cancelBooking(id);
            } else {
                System.out.println("Your booking(s) is empty");
            }
        } catch (Exception e){
            System.out.println("There aren't any user in " + id +" id");
        }
    }
}
