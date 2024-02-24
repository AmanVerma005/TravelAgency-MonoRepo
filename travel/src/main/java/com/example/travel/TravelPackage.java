package com.example.travel;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package with a name, passenger capacity, itinerary, and list of passengers.
 */
public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    /**
     * Constructs a travel package with a specified name and passenger capacity.
     *
     * @param name              The name of the travel package.
     * @param passengerCapacity The maximum number of passengers the travel package can accommodate.
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * Gets the name of the travel package.
     *
     * @return The name of the travel package.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the passenger capacity of the travel package.
     *
     * @return The passenger capacity of the travel package.
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Gets the itinerary of the travel package.
     *
     * @return The list of destinations in the travel package's itinerary.
     */
    public List<Destination> getItinerary() {
        return itinerary;
    }

    /**
     * Gets the list of passengers enrolled in the travel package.
     *
     * @return The list of passengers enrolled in the travel package.
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Adds a destination to the travel package's itinerary.
     *
     * @param destination The destination to add.
     */
    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    /**
     * Adds a passenger to the travel package.
     *
     * @param passenger The passenger to add.
     */
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Cannot add more passengers. Capacity reached.");
        }
    }

    /**
     * Prints the itinerary of the travel package.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            destination.printDestinationDetails();
        }
    }

    /**
     * Prints the list of passengers in the travel package.
     */
    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Capacity: " + passengerCapacity + ", Enrolled Passengers: " + passengers.size());
        for (Passenger passenger : passengers) {
            passenger.printPassengerDetails();
        }
    }

    /**
     * Prints the details of an individual passenger.
     *
     * @param passenger The passenger whose details to print.
     */
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details");
        passenger.printPassengerDetails();
    }

    /**
     * Prints the details of all activities with available spaces.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities for Travel Package: " + name);
        for (Destination destination : itinerary) {
            destination.printAvailableActivities();
        }
    }
}
