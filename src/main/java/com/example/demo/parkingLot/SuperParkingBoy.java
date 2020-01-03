package com.example.demo.parkingLot;

import java.util.List;

public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        return ParkingLotSelector.getParkingLotByMaxRestRate(this).park(car);
    }

    public int totalRestSpace() {
        return super.getParkingLots().stream().mapToInt(ParkingLot::restSpace).sum();
    }

    public int totalSpace() {
        return super.getParkingLots().stream().mapToInt(ParkingLot::getSize).sum();
    }

    @Override
    public String parkingLotInfo() {
        return "B " + totalRestSpace() + " " + totalSpace();
    }
}
