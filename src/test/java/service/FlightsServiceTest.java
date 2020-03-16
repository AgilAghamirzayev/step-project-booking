package service;

import dao.FlightsDAO;
import models.Airline;
import models.Airport;
import models.Flights;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightsServiceTest {

    FlightsDAO dao;
    FlightsService service;


    @BeforeEach
    public void setUp(){
        service = new FlightsService(dao);
    }

    @Test
    void getAllFlights() {

    }

    @Test
    void book() {
    }

    @Test
    void search() {
    }
}