package com.example.demo.parkingLot;

import java.util.List;

public class GraduateParkingBoy extends ParkingBoy{

    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        return ParkingLotSelector.getParkingLotBySequence(this).park(car);
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
