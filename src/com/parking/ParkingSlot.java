package com.parking;

public class ParkingSlot {
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private int spotNumber;
    private int row;
    private Level level;

    public ParkingSlot(Level level, int row, int spotNumber) {
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
    }

    public boolean park(Vehicle vehicle) {
        this.vehicle = vehicle;
        return true;
   }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getRow() {
        return row;
    }

    public void removeVehicle(){
        this.vehicle = null;
    }

    public Level getLevel() {
        return level;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
