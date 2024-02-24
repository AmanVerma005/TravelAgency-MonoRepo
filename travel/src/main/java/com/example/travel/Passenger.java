package com.example.travel;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a passenger with a name, passenger number, balance, type, and list of enrolled activities.
 */
public class Passenger {
    private String name;
    private Long passengerNumber;
    private double balance;
    private PassengerType type;
    private List<Activity> enrolledActivities;

    /**
     * Constructs a passenger with specified attributes.
     *
     * @param name           The name of the passenger.
     * @param passengerNumber The unique number assigned to the passenger.
     * @param type           The type of the passenger (STANDARD, GOLD, PREMIUM).
     * @param balance        The initial balance of the passenger.
     */
    public Passenger(String name, Long passengerNumber, PassengerType type, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.balance = balance;
        this.enrolledActivities = new ArrayList<>();
    }

    /**
     * Gets the name of the passenger.
     *
     * @return The name of the passenger.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unique number assigned to the passenger.
     *
     * @return The passenger number.
     */
    public Long getPassengerNumber() {
        return passengerNumber;
    }

    /**
     * Gets the balance of the passenger.
     *
     * @return The balance of the passenger.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the type of the passenger (STANDARD, GOLD, PREMIUM).
     *
     * @return The type of the passenger.
     */
    public PassengerType getType() {
        return type;
    }

    /**
     * Gets the list of activities enrolled by the passenger.
     *
     * @return The list of activities enrolled by the passenger.
     */
    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }

    /**
     * Enrolls the passenger for an activity.
     *
     * @param activity The activity to enroll for.
     */
    public void enrollForActivity(Activity activity) {
        if (type == PassengerType.PREMIUM || (type == PassengerType.GOLD && balance >= 0.9 * activity.getCost())
                || (type == PassengerType.STANDARD && balance >= activity.getCost())) {
            enrolledActivities.add(activity);
            activity.enrollPassenger(this);
            if (type != PassengerType.PREMIUM) {
                balance -= activity.calculatePrice(type);
            }
        } else {
            System.out.println("Unable to enroll for the activity due to insufficient balance.");
        }
    }

    /**
     * Prints the details of the passenger.
     */
    public void printPassengerDetails() {
        System.out.println("Name: " + name + ", Number: " + passengerNumber);
        if (type != PassengerType.PREMIUM) {
            System.out.println("Balance: $" + balance);
        }
        System.out.println("Enrolled Activities:");
        for (Activity activity : enrolledActivities) {
            activity.printActivityDetails();
        }
    }
}
