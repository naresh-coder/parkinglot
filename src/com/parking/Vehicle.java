package com.parking;

import java.util.ArrayList;
import java.util.List;

public  class Vehicle {

   protected String licensePlate;
   protected int noOfSlotRequired;



   public Vehicle(String licensePlate){
       this.licensePlate = licensePlate;
   }

   private List<ParkingSlot> parkingSlotList = new ArrayList<>();
   protected VehicleType vehicleType = VehicleType.CAR;


    public int getNoOfSlotRequired() {
        return noOfSlotRequired;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setNoOfSlotRequired(int noOfSlotRequired) {
        this.noOfSlotRequired = noOfSlotRequired;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        // noOf slots required for vehicle
    }
    public void parkInSpot(ParkingSlot slot){
        parkingSlotList.add(slot);

    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }
}
