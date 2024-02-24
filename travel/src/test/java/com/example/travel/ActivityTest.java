package com.example.travel;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ActivityTest {

    @Test
    void enrollPassenger_shouldEnrollPassengerForActivity() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "Description", 50.0, 20, destination);
        Passenger passenger = new Passenger("TestPassenger", Long.parseLong("1"), PassengerType.STANDARD, 100.0);

        activity.enrollPassenger(passenger);

        assertTrue(activity.getEnrolledPassengers().contains(passenger));
    }

}
