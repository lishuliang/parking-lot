package com.example.demo.parkingLot;

import java.util.List;

public class SuperParkingBoy extends GraduateParkingBoy {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        return ParkingLotSelector.getParkingLotByMaxRestRate(this).park(car);
    }
}
