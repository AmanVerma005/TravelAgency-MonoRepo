package com.example.travel;

import java.util.Scanner;

public class TravelAgencyApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for travel package
        System.out.println("Enter Travel Package Details:");
        System.out.print("Package Name: ");
        String packageName = scanner.nextLine();
        System.out.print("Passenger Capacity: ");
        int passengerCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Creating a travel package
        TravelPackage travelPackage = new TravelPackage(packageName, passengerCapacity);

        // Taking input for destinations and activities
        System.out.print("Enter the number of destinations: ");
        int numDestinations = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numDestinations; i++) {
            System.out.println("Enter Destination " + (i + 1) + " Details:");
            System.out.print("Destination Name: ");
            String destinationName = scanner.nextLine();

            Destination destination = new Destination(destinationName);
            travelPackage.addDestination(destination);

            System.out.print("Enter the number of activities for " + destinationName + ": ");
            int numActivities = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int j = 0; j < numActivities; j++) {
                System.out.println("Enter Activity " + (j + 1) + " Details:");
                System.out.print("Activity Name: ");
                String activityName = scanner.nextLine();
                System.out.print("Activity Description: ");
                String activityDescription = scanner.nextLine();
                System.out.print("Activity Cost: ");
                double activityCost = scanner.nextDouble();
                System.out.print("Activity Capacity: ");
                int activityCapacity = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                Activity activity = new Activity(activityName, activityDescription, activityCost, activityCapacity, destination);
                destination.addActivity(activity);
            }
        }

        // Taking input for passengers
        System.out.print("Enter the number of passengers: ");
        int numPassengers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numPassengers; i++) {
            System.out.println("Enter Passenger " + (i + 1) + " Details:");
            System.out.print("Passenger Name: ");
            String passengerName = scanner.nextLine();
            System.out.print("Passenger Number: ");
            Long passengerNumber = scanner.nextLong();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Passenger Type (STANDARD, GOLD, PREMIUM): ");
            String passengerTypeString = scanner.nextLine();
            PassengerType passengerType = PassengerType.valueOf(passengerTypeString.toUpperCase());
            double balance = 0.0;

            if (passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD) {
                System.out.print("Passenger Balance: ");
                balance = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
            }

            Passenger passenger = new Passenger(passengerName, passengerNumber, passengerType, balance);
            travelPackage.addPassenger(passenger);

            // Enroll passenger for activities
            for (Destination destination : travelPackage.getItinerary()) {
                for (Activity activity : destination.getActivities()) {
                    System.out.print("Enroll " + passengerName + " for " + activity.getName() + " at " + destination.getName() + " (yes/no): ");
                    String enrollChoice = scanner.nextLine();
                    if (enrollChoice.equalsIgnoreCase("yes")) {
                        passenger.enrollForActivity(activity);
                    }
                }
            }
        }

        // Print details based on tasks
        System.out.println("\nPrint Itinerary:");
        travelPackage.printItinerary();

        System.out.println("\nPrint Passenger List:");
        travelPackage.printPassengerList();

        System.out.println("\nPrint Individual Passenger Details:");
        for (Passenger passenger : travelPackage.getPassengers()) {
            passenger.printPassengerDetails();
            System.out.println(); // Add a newline for better readability
        }

        System.out.println("\nPrint Available Spaces:");
        for (Destination destination : travelPackage.getItinerary()) {
            for (Activity activity : destination.getActivities()) {
                activity.printAvailableSpaces();
            }
        }

        scanner.close();
    }
}
