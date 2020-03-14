package controller;

import models.Airline;
import models.Airport;
import models.Flights;
import service.FlightsService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class FlightsController  {
    private final FlightsService service;

    public FlightsController(FlightsService service) {
        this.service = service;
    }

    public List<Flights> getAllFlights()  {
        return service.getAllFlights();
    }

    public List<Flights> book(String  from, String to, String departure, String airline,  int passengersNum) {
        return service.book(from, to, departure, airline, passengersNum);
    }

    public List<Flights> search(String  from, String to, String departure) {
        return service.search(from, to, departure);
    }

    public Flights getFlightById(int id){
        return service.getFlightById(id);
    }

    public Optional<Flights> getAirline(String airline){
        return service.getAirline(airline);
    }
}

