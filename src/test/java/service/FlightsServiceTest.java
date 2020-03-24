package service;

import dao.FlightsDAO;
import models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

class FlightsServiceTest {

FlightsDAO dao = new FlightsDAO();

    FlightsService service ;
    private Flights flights;

    @BeforeEach
    public void setUp(){
         service = new FlightsService(dao);
         flights = new Flights(1, Airline.MANGO, Airport.KIEV,Airport.COLOMBIA, LocalDateTime.of(2020, 9,24,19,40),88);
    }


    @Test
    void getAllFlights() {
        String expect = "|001|  |  MANGO               |  |  KIEV      |  |  COLOMBIA  |  |2020-09-24 19:40|  | 087 |";
        String actual = flights.toString();
        assertEquals(expect,actual);
    }

    @Test
    void book() {
        List<Flights> actual = service.book(flights.getFrom().toString(),flights.getTo().toString(),flights.getDeparture().toString(),flights.getAirline().toString(),flights.getAvailableSeats());
        assertTrue(actual.isEmpty());
    }

    @Test
    void search() {
        String actual = service.search(1).get(0).toString();
        String expect = dao.getAll().stream().filter(f->f.getId()==1).findFirst().get().toString();
        assertEquals(actual,expect);
    }
}