package controller;

import models.Airport;
import models.Flights;
import service.FlightsService;
import java.time.LocalDate;
import java.util.List;


public class FlightsController  {
    private final FlightsService service;

    public FlightsController(FlightsService service) {
        this.service = service;
    }

    public List<Flights> getAllFlights()  {
        return service.getAllFlights();
    }

    public List<Flights> search(Airport from, Airport to, LocalDate departure, int passengersnum) {
        return service.search(from, to, departure, passengersnum);
    }

    public Flights getFlightById(int id){
        return service.getFlightById(id);
    }
}

