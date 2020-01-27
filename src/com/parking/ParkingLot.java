package com.parking;

import java.util.PriorityQueue;

/**
 *  Class to avail total no parking slots
 */
public class ParkingLot {

    private Level[] levels = new Level[1];

    public ParkingLot(int noOfSpot) {
        this(0, noOfSpot);
    }

    public ParkingLot(int no, int noOfSpot) {
        levels[no] = new Level(noOfSpot);
    }

    public Level[] getLevels() {
        return levels;
    }
}
