package dao;

import models.Airline;
import models.Airport;
import models.Flights;
import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;


public class FlightsDAO  implements DAO<Flights> {

    private static List<Flights> flights = new ArrayList<>();
    private  File file = new File("flightsFile.txt");

    @Override
    public Flights get(int id) {
        write();
        return flights.get(id);
    }

    @Override
    public Collection<Flights> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream( new BufferedInputStream(new FileInputStream(file)))) {
            return (List<Flights>) ois.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void create(Flights flight) {
        write();
        flights.add(flight);
    }

    @Override
    public void delete(int id) {
        flights.remove(id);
        write();
    }

    @Override
    public void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            Random random = new Random();
            for (int i = 1; i <= 60; i++) {
                Month month=Month.values()[random.nextInt(Month.values().length)];
                Airport from = Airport.valueOf("KIEV");
                Airport to = Airport.values()[random.nextInt(Airport.values().length)];
                if (!from.equals(to)){
                    flights.add(new Flights(i,
                            Airline.values()[random.nextInt(Airline.values().length)],
                            from,
                            to,
                            LocalDateTime.of(2020, month,random.nextInt(month.length(true))+1,random.nextInt(23),random.nextInt(59)),
                            (random.nextInt(150-70+1)+70)));
                } else {
                    i--;
                }
            }
            oos.writeObject(flights);
        } catch (IOException ignored){

        }
    }
}
