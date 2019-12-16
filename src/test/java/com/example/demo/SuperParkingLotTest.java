package com.example.demo;

import com.example.demo.parkingLot.Car;
import com.example.demo.parkingLot.ParkingLot;
import com.example.demo.parkingLot.SuperParkingBoy;
import com.example.demo.parkingLot.Ticket;
import com.example.demo.parkingLot.exception.NoSpaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

class SuperParkingLotTest {

    private ParkingLot parkingLotFirst;
    private ParkingLot parkingLotSecond;
    private SuperParkingBoy superParkingBoy;

    @BeforeEach
    void setUp() {
        parkingLotFirst = Mockito.spy(new ParkingLot(10));
        parkingLotSecond = Mockito.spy(new ParkingLot(10));
        superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLotFirst, parkingLotSecond));
    }

    @Test
    void should_park_in_second_when_the_second_rest_rate_biggger() {
        Car car = new Car("11");
        doReturn(0.2).when(parkingLotFirst).restRate();
        doReturn(0.5).when(parkingLotSecond).restRate();

        Ticket ticket = superParkingBoy.park(car);

        assertEquals(ticket.getCarNum(), "11");
    }

    @Test
    void should_park_in_first_when_the_same_rest_rate() {
        Car car = new Car("11");
        doReturn(0.5).when(parkingLotFirst).restRate();
        doReturn(0.5).when(parkingLotSecond).restRate();
        doReturn(4).when(parkingLotFirst).restSpace();

        superParkingBoy.park(car);

        assertEquals(parkingLotFirst.restSpace(), 4);
    }

    @Test
    void should_park_failed_when_no_space() {
        doReturn(false).when(parkingLotFirst).isNotFull();
        doReturn(false).when(parkingLotSecond).isNotFull();

        assertThrows(NoSpaceException.class, () -> superParkingBoy.park(new Car("11")));
    }

    @Test
    void should_pick_when_has_park() {
        Ticket ticket = new Ticket("11");
        doReturn(true).when(parkingLotFirst).isContainCar(ticket);

        assertTrue(superParkingBoy.pick(ticket));
    }
}
