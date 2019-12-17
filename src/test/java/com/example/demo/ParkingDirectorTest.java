package com.example.demo;

import com.example.demo.parkingLot.GraduateParkingBoy;
import com.example.demo.parkingLot.ParkingDirector;
import com.example.demo.parkingLot.ParkingLot;
import com.example.demo.parkingLot.ParkingManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class ParkingDirectorTest {

    private ParkingDirector parkingDirector;
    private ParkingManager parkingManager;
    private ParkingLot firstParkingLot;
    private ParkingLot secondParkingLot;
    private ParkingLot thirdParkingLot;
    private ParkingLot fourthParkingLot;
    private GraduateParkingBoy firstGraduateParkingBoy;
    private GraduateParkingBoy secondGraduateParkingBoy;

    @BeforeEach
    void setUp() {
        firstParkingLot = spy(new ParkingLot(10));
        secondParkingLot = spy(new ParkingLot(5));
        thirdParkingLot = spy(new ParkingLot(3));
        fourthParkingLot = spy(new ParkingLot(2));
        firstGraduateParkingBoy = spy(new GraduateParkingBoy(Collections.singletonList(secondParkingLot)));
        secondGraduateParkingBoy = spy(new GraduateParkingBoy(Arrays.asList(thirdParkingLot, fourthParkingLot)));
        parkingManager = new ParkingManager(Collections.singletonList(firstParkingLot),
                                        Arrays.asList(firstGraduateParkingBoy, secondGraduateParkingBoy));
        parkingDirector = new ParkingDirector(parkingManager);
    }

    @Test
    void should_print_string_info() {
        doReturn(2).when(firstParkingLot).restSpace();
        doReturn(2).when(secondParkingLot).restSpace();
        doReturn(0).when(thirdParkingLot).restSpace();
        doReturn(1).when(fourthParkingLot).restSpace();

        assertEquals(parkingDirector.printStringAllParkingLotInfo(),
                "M 5 20\n" +
                    " P 2 10\n" +
                    " B 2 5\n" +
                    "  P 2 5\n" +
                    " B 1 5\n" +
                    "  P 0 3\n" +
                    "  P 1 2\n");
    }

    @Test
    void should_print_markdown_info() {
        doReturn(2).when(firstParkingLot).restSpace();
        doReturn(2).when(secondParkingLot).restSpace();
        doReturn(0).when(thirdParkingLot).restSpace();
        doReturn(1).when(fourthParkingLot).restSpace();

        assertEquals(parkingDirector.printMarkdownAllParkingLotInfo(),
                "M 5 20\n" +
                        "#P 2 10\n" +
                        "#B 2 5\n" +
                        "##P 2 5\n" +
                        "#B 1 5\n" +
                        "##P 0 3\n" +
                        "##P 1 2\n");
    }
}
