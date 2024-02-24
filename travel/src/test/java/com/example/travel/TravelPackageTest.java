package com.example.travel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TravelPackageTest {

    @Test
    void addDestination_shouldAddDestinationToItinerary() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 10);
        Destination destination = new Destination("TestDestination");

        travelPackage.addDestination(destination);

        assertTrue(travelPackage.getItinerary().contains(destination));
    }

    @Test
    void addPassenger_shouldAddPassengerToPackage() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 10);
        Passenger passenger = new Passenger("TestPassenger", Long.parseLong("1"), PassengerType.STANDARD, 100.0);

        travelPackage.addPassenger(passenger);

        assertTrue(travelPackage.getPassengers().contains(passenger));
    }
}
