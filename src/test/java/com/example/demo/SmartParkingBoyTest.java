package com.example.demo;

import com.example.demo.parkingLot.Car;
import com.example.demo.parkingLot.ParkingLot;
import com.example.demo.parkingLot.SmartParkingBoy;
import com.example.demo.parkingLot.Ticket;
import com.example.demo.parkingLot.exception.NoSpaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {

    private ParkingLot parkingLotFirst;
    private ParkingLot parkingLotSecond;
    private SmartParkingBoy smartParkingBoy;

    @BeforeEach
    void setUp() {
        parkingLotFirst = new ParkingLot(1);
        parkingLotSecond = new ParkingLot(2);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLotFirst, parkingLotSecond);
        smartParkingBoy = new SmartParkingBoy(parkingLots);
    }

    @Test
    void should_park_in_second_parking_lot_when_rest_space_different() {
        smartParkingBoy.park(new Car("1"));

        assertEquals(parkingLotSecond.restSpace(), 1);
    }

    @Test
    void should_park_by_sequence_when_has_same_rest_space() {
        parkingLotSecond.park(new Car("1"));

        smartParkingBoy.park(new Car("2"));

        assertEquals(parkingLotFirst.restSpace(), 0);
    }

    @Test
    void should_not_park_when_not_enough_space() {
        parkingLotFirst.park(new Car("1"));
        parkingLotSecond.park(new Car("2"));
        parkingLotSecond.park(new Car("3"));

        assertThrows(NoSpaceException.class, () -> smartParkingBoy.park(new Car("4")));
    }

    @Test
    void should_pick_when_parked() {
        Ticket ticket = parkingLotSecond.park(new Car("1"));

        smartParkingBoy.pick(ticket);

        assertEquals(parkingLotSecond.restSpace(), 2);
    }
}
