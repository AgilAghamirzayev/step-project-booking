package models;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int counter;

    private final int id;
    private final String firstName;
    private final String lastName;


    public Passenger( String firstName, String lastName) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Passenger(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("first name: %s, last name: %s ",firstName,lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id &&
                Objects.equals(firstName, passenger.firstName) &&
                Objects.equals(lastName, passenger.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
