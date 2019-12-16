package com.example.demo.parkingLot;

import com.example.demo.parkingLot.exception.NoAuthorityException;

import java.util.List;

public class ParkingManager extends ParkingBoy{
    private List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    @Override
    public Ticket park(Car car) {
        return ParkingLotSelector.getParkingLotBySequence(this).park(car);
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public Ticket assignedPark(ParkingBoy parkingBoy, Car car) {
        if (!isOrderParkingBoy(parkingBoy)) throw new NoAuthorityException();
        return parkingBoy.park(car);
    }

    public boolean assignedPick(ParkingBoy parkingBoy, Ticket ticket) {
        if (!isOrderParkingBoy(parkingBoy)) throw new NoAuthorityException();
        return parkingBoy.pick(ticket);
    }

    public boolean isOrderParkingBoy(ParkingBoy parkingBoy) {
        return this.parkingBoys.contains(parkingBoy);
    }
}
