package com.example.travel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void enrollForActivity_shouldEnrollPassengerForActivity() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "Description", 50.0, 20, destination);
        Passenger passenger = new Passenger("TestPassenger", Long.parseLong("1"), PassengerType.STANDARD, 100.0);

        passenger.enrollForActivity(activity);

        assertTrue(passenger.getEnrolledActivities().contains(activity));
    }
}
