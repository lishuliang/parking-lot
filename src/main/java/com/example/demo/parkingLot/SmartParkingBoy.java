package com.example.demo.parkingLot;

import com.example.demo.parkingLot.exception.NoSpaceException;
import com.example.demo.parkingLot.exception.NotExistException;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream().max(Comparator.comparingInt(ParkingLot::restSpace)).orElseThrow(NoSpaceException::new);
        return parkingLot.park(car);
    }

    public void pick(Ticket ticket) {
        ParkingLot parkingLot = parkingLots.stream().filter(p -> p.isContainCar(ticket)).findFirst().orElseThrow(NotExistException::new);
        parkingLot.pick(ticket);
    }
}
