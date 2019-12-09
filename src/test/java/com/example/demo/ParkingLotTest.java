package com.example.demo;

import com.example.demo.parkingLot.Car;
import com.example.demo.parkingLot.ParkingLot;
import com.example.demo.parkingLot.Ticket;
import com.example.demo.parkingLot.exception.NoSpaceException;
import com.example.demo.parkingLot.exception.NotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(1);
    }

    @Test
    void should_parking_when_has_space() {
        Car car = new Car("1");

        assertNotNull(parkingLot.park(car));
    }

    @Test
    void should_pick_when_has_parked() {
        Car car = new Car("1");
        Ticket ticket = parkingLot.park(car);

        assertTrue(parkingLot.pick(ticket));
    }

    @Test
    void should_not_pick_when_not_parking() {
        assertThrows(NotExistException.class, () -> parkingLot.pick(new Ticket()));
    }

    @Test
    void should_not_parking_when_parked_full() {
        parkingLot.park(new Car("222"));

        assertThrows(NoSpaceException.class, () -> parkingLot.park(new Car("111")));
    }
}
