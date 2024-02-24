package com.example.travel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DestinationTest {

    @Test
    void addActivity_shouldAddActivityToDestination() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "Description", 50.0, 20, destination);

        destination.addActivity(activity);

        assertTrue(destination.getActivities().contains(activity));
    }
}
