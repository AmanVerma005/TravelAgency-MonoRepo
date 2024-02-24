package com.example.travel;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an activity with a name, description, cost, capacity, and destination.
 */
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> enrolledPassengers;

    /**
     * Constructs an activity with specified attributes.
     *
     * @param name        The name of the activity.
     * @param description The description of the activity.
     * @param cost        The cost of the activity.
     * @param capacity    The capacity of the activity.
     * @param destination The destination where the activity takes place.
     */
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.enrolledPassengers = new ArrayList<>();
    }

    /**
     * Gets the name of the activity.
     *
     * @return The name of the activity.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the cost of the activity.
     *
     * @return The cost of the activity.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the capacity of the activity.
     *
     * @return The capacity of the activity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the destination of the activity.
     *
     * @return The destination of the activity.
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Gets the list of enrolled passengers for the activity.
     *
     * @return The list of enrolled passengers for the activity.
     */
    public List<Passenger> getEnrolledPassengers() {
        return enrolledPassengers;
    }

    /**
     * Enrolls a passenger for the activity.
     *
     * @param passenger The passenger to enroll.
     */
    public void enrollPassenger(Passenger passenger) {
        if (enrolledPassengers.size() < capacity && !enrolledPassengers.contains(passenger)) {
            enrolledPassengers.add(passenger);
        } else {
            System.out.println("Cannot enroll more passengers or passenger is already enrolled.");
        }
    }

    /**
     * Gets the remaining capacity for the activity.
     *
     * @return The remaining capacity for the activity.
     */
    public int getRemainingCapacity() {
        return capacity - enrolledPassengers.size();
    }

    /**
     * Calculates the price for the activity based on passenger type.
     *
     * @param passengerType The type of the passenger (STANDARD, GOLD, PREMIUM).
     * @return The calculated price for the activity.
     */
    public double calculatePrice(PassengerType passengerType) {
        switch (passengerType) {
            case STANDARD:
                return cost;
            case GOLD:
                return 0.9 * cost;
            case PREMIUM:
                return 0.0; // Premium passengers enroll for free
            default:
                return 0.0;
        }
    }

    /**
     * Prints the details of the activity.
     */
    public void printActivityDetails() {
        System.out.println("Activity: " + name + ", Cost: $" + cost +
                ", Capacity: " + capacity + ", Description: " + description);
    }

    /**
     * Prints the details of available spaces for the activity.
     */
    public void printAvailableSpaces() {
        System.out.println("Activity: " + name + ", Destination: " + destination.getName() +
                ", Remaining Spaces: " + getRemainingCapacity());
    }
}
