package com.example.demo.parkingLot;

import com.example.demo.parkingLot.exception.NoSpaceException;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = super.getParkingLots().stream().max(Comparator.comparingInt(ParkingLot::restSpace)).orElseThrow(NoSpaceException::new);
        return parkingLot.park(car);
    }
}
