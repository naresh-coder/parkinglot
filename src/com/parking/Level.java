package com.parking;

import java.util.*;

/**
 *  class store floor level parking
 */
public class Level {
    private int floor = 0;
    private ParkingSlot[] spots;
    private int availableSlots = 0;
    private Map<String,Vehicle> vehicleMap = new HashMap<>();

    private Map<String, List<Vehicle>> sortByColorMap = new HashMap<>();

    PriorityQueue<ParkingSlot> parkingSlots = new PriorityQueue<>(Comparator.comparing(w -> w.getSpotNumber()));

    Level(int noOfSlots) {
        this.availableSlots = noOfSlots;
        spots = new ParkingSlot[noOfSlots];
        int row = 1;
        for (int i = 0; i < noOfSlots; i++) {
            spots[i] = new ParkingSlot(this, row, i + 1);
            parkingSlots.add( spots[i]);
            if ((i + 1)%5 == 0) {
                row++;
            }
        }

    }

    public int parkVehicle(Vehicle vehicle) {
//        if(findVehicleByLicense(vehicle.getLicensePlate())== null){
//            System.out.println(" vehicle is already parked  at  "+vehicle.getParkingSlotList().get(0).getSpotNumber());
//            return vehicle.getParkingSlotList().get(0).getSpotNumber();
//        }

        if(availableSlots == 0){
            throw new RuntimeException(" Sorry Parking Full ");
        }
        vehicleMap.put(vehicle.getLicensePlate(),vehicle);
        ParkingSlot spot = parkingSlots.peek();
        vehicle.getParkingSlotList().add(spot);
        spot.park(vehicle);
        parkingSlots.poll();
        availableSlots--;

        return spot.getSpotNumber();
    }

    public int removeVehicle(Vehicle vehicle) {
          if(findVehicleByLicense(vehicle.getLicensePlate())== null){
              System.out.println(" vehicle is not parked ");
              return -1;
          }
        if ( !vehicle.getParkingSlotList().isEmpty()) {
            ParkingSlot spot = vehicle.getParkingSlotList().get(0);
            spot.removeVehicle();
            vehicleMap.remove(vehicle.getLicensePlate());
            parkingSlots.add(spot);
            availableSlots++;
            vehicle.getParkingSlotList().clear();
            return spot.getSpotNumber();
        }
        return 0;

    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public Vehicle findVehicleByLicense(String license){
        return vehicleMap.get(license);
    }
}
