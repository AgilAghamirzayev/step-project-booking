package service;

import dao.FlightsDAO;
import models.Airport;
import models.Flights;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightsService  {

    private final FlightsDAO dao;

    public FlightsService(FlightsDAO dao) {
        this.dao = dao;
    }

    public List<Flights> getAllFlights() {
        return new ArrayList<>(dao.getAll());
    }

    public List<Flights> book(String from, String to, String departure,String airline, int passengersNum) {
        return dao.getAll().stream().filter(f->
                                from.equals(f.getFrom().toString()) &&
                                to.equals(f.getTo().toString()) &&
                                departure.equals(f.getDeparture().toLocalDate().toString()) &&
                                airline.equals(f.getAirline().toString()) &&
                                passengersNum <= f.getAvailableSeats()).collect(Collectors.toList());
    }

    public List<Flights> search(String from, String to, String departure) {
        return dao.getAll().stream().filter(f->
                        from.equals(f.getFrom().toString()) &&
                                to.equals(f.getTo().toString()) &&
                                departure.equals(f.getDeparture().toLocalDate().toString())).collect(Collectors.toList());
    }

    public Flights getFlightById(int id){
        return dao.get(id);
    }

    public Optional<Flights> getAirline(String airline){
        return dao.getAll().stream()
                .filter(flights -> flights.getAirline().toString().equals(airline)).findAny();
    }


}

