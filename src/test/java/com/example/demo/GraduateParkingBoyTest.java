package com.example.demo;

import com.example.demo.parkingLot.Car;
import com.example.demo.parkingLot.GraduateParkingBoy;
import com.example.demo.parkingLot.ParkingLot;
import com.example.demo.parkingLot.Ticket;
import com.example.demo.parkingLot.exception.NoSpaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GraduateParkingBoyTest {

    private ParkingLot parkingLotFirst;
    private ParkingLot parkingLotSecond;
    private GraduateParkingBoy parkingBoy;

    @BeforeEach
    void setUp() {
        parkingLotFirst = new ParkingLot(1);
        parkingLotSecond = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLotFirst, parkingLotSecond);
        parkingBoy = new GraduateParkingBoy(parkingLots);
    }

    @Test
    void should_park_first_when_all_enough_space() {
        Car car = new Car("1");

        parkingBoy.park(car);

        assertEquals(parkingLotFirst.restSpace(), 0);
        assertEquals(parkingLotSecond.restSpace(), 1);
    }

    @Test
    void should_park_second_when_fist_is_full() {
        parkingLotFirst.park(new Car("1"));
        assertEquals(parkingLotFirst.restSpace(), 0);
        Car car = new Car("2");

        parkingBoy.park(car);

        assertEquals(parkingLotSecond.restSpace(), 0);
    }

    @Test
    void should_not_park_when_all_is_full() {
        parkingLotFirst.park(new Car("1"));
        parkingLotSecond.park(new Car("2"));

        Car car = new Car("3");

        assertThrows(NoSpaceException.class, () -> parkingBoy.park(car));
    }

    @Test
    void should_pick_when_has_parked() {
        Ticket ticket = parkingBoy.park(new Car("1"));

        parkingBoy.pick(ticket);

        assertEquals(parkingLotFirst.restSpace(), 1);
        assertEquals(parkingLotSecond.restSpace(), 1);
    }

    @Test
    void should_print_parking_boy_info() {
        assertEquals(parkingBoy.parkingLotInfo(), "B 2 2");
    }
}
