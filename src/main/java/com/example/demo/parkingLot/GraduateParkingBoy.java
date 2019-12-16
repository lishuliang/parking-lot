package com.example.demo.parkingLot;

import java.util.List;

public class GraduateParkingBoy extends ParkingBoy{

    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        return ParkingLotSelector.getParkingLotBySequence(this).park(car);
    }
}
