package com.example.demo.parkingLot;

import com.example.demo.parkingLot.exception.NoSpaceException;

import java.util.Comparator;

public class ParkingLotSelector {

    public static ParkingLot getParkingLotBySequence(ParkingBoy parkingBoy) {
        return parkingBoy.getParkingLots().stream()
                .filter(ParkingLot::isNotFull)
                .findFirst()
                .orElseThrow(NoSpaceException::new);
    }

    public static ParkingLot getParkingLotByMaxRestSpace(ParkingBoy parkingBoy) {
        return parkingBoy.getParkingLots().stream()
                .filter(ParkingLot::isNotFull)
                .max(Comparator.comparingInt(ParkingLot::restSpace))
                .orElseThrow(NoSpaceException::new);
    }


    public static ParkingLot getParkingLotByMaxRestRate(ParkingBoy parkingBoy) {
        return parkingBoy.getParkingLots().stream()
                .filter(ParkingLot::isNotFull)
                .max(Comparator.comparingDouble(ParkingLot::restRate))
                .orElseThrow(NoSpaceException::new);
    }
}
