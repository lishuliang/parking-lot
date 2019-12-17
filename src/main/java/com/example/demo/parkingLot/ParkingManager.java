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
        if (isAssignedParkingBoy(parkingBoy)) throw new NoAuthorityException();
        return parkingBoy.park(car);
    }

    public boolean assignedPick(ParkingBoy parkingBoy, Ticket ticket) {
        if (isAssignedParkingBoy(parkingBoy)) throw new NoAuthorityException();
        return parkingBoy.pick(ticket);
    }

    public boolean isAssignedParkingBoy(ParkingBoy parkingBoy) {
        return !this.parkingBoys.contains(parkingBoy);
    }

    public int totalRestSpace() {
        return super.getParkingLots().stream().mapToInt(ParkingLot::restSpace).sum() +
                this.parkingBoys.stream().mapToInt(ParkingBoy::totalRestSpace).sum();
    }

    public int totalSpace() {
        return super.getParkingLots().stream().mapToInt(ParkingLot::getSize).sum() +
                this.parkingBoys.stream().mapToInt(ParkingBoy::totalSpace).sum();
    }

    @Override
    public String parkingLotInfo() {
        return "M " + totalRestSpace() + " " + totalSpace();
    }
}
