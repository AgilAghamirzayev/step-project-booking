package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flights implements Serializable {
    private static final long serialVersionUID = 1L;

    private  int id;
    private  int size;
    private  Airline airline;
    private  Airport src;
    private  Airport dst;
    private  LocalDateTime departure;
    private  List<Passenger> passengers;


    public Flights(int id, Airline airline, Airport from, Airport to, LocalDateTime departure,  int size) {
        this.id = id;
        this.airline = airline;
        this.src = from;
        this.dst = to;
        this.size = size;
        this.departure = departure;
        this.passengers = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public Airline getAirline() {
        return airline;
    }

    public Airport getFrom() {
        return src;
    }

    public Airport getTo() {
        return dst;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }


    void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    public int getAvailableSeats(){
        return size - passengers.size();
    }

    @Override
    public String toString() {
        return String.format("|%03d|  |  %-20s|  |  %-10s|  |  %-10s|  |%-16s|  | %03d |", id, airline, src,dst,departure.toString().replace("T", " "), getAvailableSeats());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flights flights = (Flights) o;
        return id == flights.id &&
                size == flights.size &&
                airline == flights.airline &&
                src == flights.src &&
                dst == flights.dst &&
                Objects.equals(departure, flights.departure) &&
                Objects.equals(passengers, flights.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, airline, src, dst, departure, passengers);
    }
}
