package service;

import dao.FlightsDAO;
import models.Airport;
import models.Booking;
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

    public List<Flights> search(int  id) {
        return dao.getAll().stream().filter(f->id==f.getId()).collect(Collectors.toList());
    }

}

