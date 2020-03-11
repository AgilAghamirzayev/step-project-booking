package service;

import dao.FlightsDAO;
import models.Airport;
import models.Flights;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsService  {
    private final FlightsDAO dao;

    public FlightsService(FlightsDAO dao) {
        this.dao = dao;
    }

    public List<Flights> getAllFlights() {
        return new ArrayList<>(dao.getAll());
    }

    public List<Flights> search(Airport from, Airport to, LocalDate departure, int passengersnum) {
        return dao.getAll().stream()
                .filter(f->
                        from.equals(f.getFrom()) &&
                        to.equals(f.getTo()) &&
                        (f.getDeparture().toLocalDate().equals(departure)) &&
                        f.getAvailableSeats()>=passengersnum).collect(Collectors.toList());
    }

    public Flights getFlightById(int id){
        return dao.get(id);
    }

    public void displayAllFlights(){
        dao.read();
    }



}
