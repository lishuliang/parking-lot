package com.example.demo;

import com.example.demo.parkingLot.Car;
import com.example.demo.parkingLot.GraduateParkingBoy;
import com.example.demo.parkingLot.ParkingLot;
import com.example.demo.parkingLot.ParkingManager;
import com.example.demo.parkingLot.SmartParkingBoy;
import com.example.demo.parkingLot.SuperParkingBoy;
import com.example.demo.parkingLot.Ticket;
import com.example.demo.parkingLot.exception.NoAuthorityException;
import com.example.demo.parkingLot.exception.NoSpaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class ParkingManagerTest {

    private ParkingManager parkingManager;
    private ParkingLot firstParkingLot;
    private ParkingLot secondParkingLot;
    private SmartParkingBoy smartParkingBoy;
    private SuperParkingBoy superParkingBoy;

    @BeforeEach
    void setUp() {
        firstParkingLot = spy(new ParkingLot(10));
        secondParkingLot = spy(new ParkingLot(10));
        smartParkingBoy = spy(new SmartParkingBoy(Collections.singletonList(secondParkingLot)));
        parkingManager = new ParkingManager(Arrays.asList(firstParkingLot, secondParkingLot),
                                Collections.singletonList(smartParkingBoy));
    }

    @Test
    void should_park_with_parking_manager_by_sequence() {
        Car car = new Car("11");

        Ticket ticket = parkingManager.park(car);

        assertEquals(ticket.getCarNum(), "11");
        assertEquals(firstParkingLot.restSpace(), 9);
    }

    @Test
    void should_pick_by_parking_manager() {
        Ticket ticket = new Ticket("11");
        doReturn(true).when(secondParkingLot).isContainCar(ticket);

        assertTrue(parkingManager.pick(ticket));
    }

    @Test
    void should_park_when_assign_other_parking_boy() {
        Ticket ticket = parkingManager.assignedPark(smartParkingBoy, new Car("11"));

        assertEquals(ticket.getCarNum(), "11");
    }

    @Test
    void should_not_park_when_second_parking_lot_is_full() {
        doReturn(false).when(secondParkingLot).isNotFull();

        assertThrows(NoSpaceException.class, () -> parkingManager.assignedPark(smartParkingBoy, new Car("11")));
    }

    @Test
    void should_not_park_when_not_order_parking_boy() {
        assertThrows(NoAuthorityException.class, () -> parkingManager.assignedPark(new GraduateParkingBoy(null), new Car("11")));
    }

    @Test
    void should_pick_when_assign_parking_boy() {
        Ticket ticket = new Ticket("11");
        doReturn(true).when(secondParkingLot).isContainCar(ticket);

        assertTrue(parkingManager.assignedPick(smartParkingBoy, ticket));
    }

    @Test
    void should_not_pick_when_not_order_parking_boy() {
        assertThrows(NoAuthorityException.class, () -> parkingManager.assignedPick(new GraduateParkingBoy(null), null));
    }

    @Test
    void should_print_manager_parking_lot_info() {
        doReturn(5).when(firstParkingLot).restSpace();
        parkingManager = new ParkingManager(Collections.singletonList(firstParkingLot),
                Collections.singletonList(smartParkingBoy));

        assertEquals(parkingManager.parkingLotInfo(), "M 15 20");
    }
}
