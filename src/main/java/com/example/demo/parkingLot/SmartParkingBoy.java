package com.example.demo.parkingLot;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        return ParkingLotSelector.getParkingLotByMaxRestSpace(this).park(car);
    }
}
