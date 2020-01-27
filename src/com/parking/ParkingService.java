package com.parking;

import java.util.Scanner;

public class ParkingService {
    static ParkingLot parkingLot = new ParkingLot(30);
    static Level level = parkingLot.getLevels()[0];


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String licenceNumber = scanner.next();
            Vehicle vehicle = new Vehicle(licenceNumber);
            parkVehicle(vehicle);
        }


        for (int i = 0; i < 3; i++) {
            String licenceNumber = scanner.next();
            // Vehicle vehicle = new Vehicle(licenceNumber);
            remove(licenceNumber);
        }

        for (int i = 0; i < 2; i++) {
            String licenceNumber = scanner.next();
            Vehicle vehicle = new Vehicle(licenceNumber);
            parkVehicle(vehicle);
        }

    }

    public static int parkVehicle(Vehicle vehicle) {
        int spotNumber = level.parkVehicle(vehicle);
        System.out.println("  parking at  " + spotNumber);
        return spotNumber;
    }

    public static int remove(String licenceNumber) {
        Level level = parkingLot.getLevels()[0];
        Vehicle vehicle = level.findVehicleByLicense(licenceNumber);
        int spotNumber = level.removeVehicle(vehicle);
        System.out.println(" removed parking  " + spotNumber);
        return spotNumber;
    }


}
