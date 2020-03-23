package controller;

import models.*;
import service.FlightsService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class FlightsController  {

    private final FlightsService service;
    private static Scanner scanner = new Scanner(System.in);

    public FlightsController(FlightsService service) {
        this.service = service;
    }


    public List<Flights> getAllFlights()  {
        return service.getAllFlights();
    }

    public List<Flights> book(String  from, String to, String departure, String airline,  int passengersNum) {
        return service.book(from, to, departure, airline, passengersNum);
    }

    public void search() {
        int id = 0;
        try {
            System.out.print("Enter id of flight: ");
            id = Integer.parseInt(scanner.nextLine());
            if (service.search(id).isEmpty()) {
                System.out.println("There aren't available flight");
            } else {
                System.out.println("===================================     SEARCHING     ======================================");
                System.out.println("| ID|  |       AIRLINES       |  |  FLY FROM  |  |   FLY TO   |  |   DATE-TIME    |  |SEATS|");
                System.out.println("============================================================================================");
                service.search(id).forEach(System.out::println);
                System.out.println("============================================================================================");
            }
        }  catch (Exception e){
            System.out.println("There aren't any user in " + id +" id");
        }
    }

    public void showTimetable() {
        System.out.println("===================================     TIMETABLE    =======================================");
        System.out.println("| ID|  |       AIRLINES       |  |  FLY FROM  |  |   FLY TO   |  |   DATE-TIME    |  |SEATS|");
        System.out.println("============================================================================================");
        service.getAllFlights().forEach(System.out::println);
        System.out.println("============================================================================================");
    }
}

