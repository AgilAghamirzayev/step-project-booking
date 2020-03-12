package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flights implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int counter=1;

    private int id;
    private  int size;
    private  Airline airline;
    private  Airport src;
    private  Airport dst;
    private  LocalDateTime departure;
    private  List<Passenger> passengers;

    public Flights(Airline airline, Airport from, Airport to, LocalDateTime departure, List<Passenger> passengers, int size) {
        this.id = counter++;
        this.airline = airline;
        this.src = from;
        this.dst = to;
        this.size = size;
        this.departure = departure;
        this.passengers = passengers;
    }



    public Flights(int id, Airline airline, Airport from, Airport to, LocalDateTime departure,  int size) {
        this.id = id;
        this.airline = airline;
        this.src = from;
        this.dst = to;
        this.size = size;
        this.departure = departure;
        this.passengers = new ArrayList<>();
    }


    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
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

    public List<Passenger> getPassengers() {
        return passengers;
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

}
