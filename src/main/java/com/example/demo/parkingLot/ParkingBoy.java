package com.example.demo.parkingLot;

import com.example.demo.parkingLot.exception.NotExistException;

import java.util.List;

public abstract class ParkingBoy {
    private List<ParkingLot> parkingLots;

    ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Ticket park(Car car);

    public boolean pick(Ticket ticket) {
        return parkingLots.stream()
                .filter(p -> p.isContainCar(ticket))
                .findFirst()
                .orElseThrow(NotExistException::new)
                .pick(ticket);
    }

    List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public abstract int totalRestSpace();

    public abstract int totalSpace();

    public abstract String parkingLotInfo();
}
