package com.example.travel;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination with a name and a list of activities.
 */
public class Destination {
    private String name;
    private List<Activity> activities;

    /**
     * Constructs a destination with a specified name.
     *
     * @param name The name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /**
     * Gets the name of the destination.
     *
     * @return The name of the destination.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of activities available at the destination.
     *
     * @return The list of activities available at the destination.
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Adds an activity to the destination.
     *
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Prints the details of the destination.
     */
    public void printDestinationDetails() {
        System.out.println("Destination: " + name);
        for (Activity activity : activities) {
            activity.printActivityDetails();
        }
    }

    /**
     * Prints the details of available activities at the destination.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities at Destination " + name + ":");
        for (Activity activity : activities) {
            activity.printAvailableSpaces();
        }
    }
}
