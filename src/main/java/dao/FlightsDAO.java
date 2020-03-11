package dao;

import models.Airline;
import models.Airport;
import models.Flights;
import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;


public class FlightsDAO  implements DAO<Flights> {

    private Map<Integer, Flights> flights = new HashMap<>();
    private File flightsFile = new File("flightsfile.txt");

    @Override
    public Flights get(int id) {
        return flights.get(id);
    }

    @Override
    public Collection<Flights> getAll()  {
        Random random = new Random();
        for (int i = 1; i <= 60; i++) {
            Month month=Month.values()[random.nextInt(Month.values().length)];
            Airport from = Airport.valueOf("KIEV");
            Airport to = Airport.values()[random.nextInt(Airport.values().length)];
            if (!from.equals(to)){
                flights.put(i,new Flights(i,
                        Airline.values()[random.nextInt(Airline.values().length)],
                        from,
                        to,
                        LocalDateTime.of(2020, month,random.nextInt(month.length(true))+1,random.nextInt(23),random.nextInt(59)),
                        (random.nextInt(150-70+1)+70)));
            } else {
                i--;
            }


        }
        return new ArrayList<>(flights.values());
    }

    @Override
    public void create(Flights flight) {
        flights.put(flight.getId(), flight);
    }

    @Override
    public void delete(int id) {
        flights.remove(id);
        write();
    }

    @Override
    public void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(flightsFile)))){
            oos.writeObject(getAll().toArray());
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void read() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(flightsFile)))){
            flights = (Map<Integer, Flights>) ois.readObject();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
