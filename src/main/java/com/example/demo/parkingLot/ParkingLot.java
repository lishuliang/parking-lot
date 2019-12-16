package com.example.demo.parkingLot;

import com.example.demo.parkingLot.exception.NoSpaceException;
import com.example.demo.parkingLot.exception.NotExistException;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket, Car> cars = new HashMap<>();
    private int size;

    public ParkingLot(int size) {
        this.size = size;
    }

    public Ticket park(Car car) {
        if (isNotFull()) {
            Ticket ticket = new Ticket(car.getCarNum());
            this.cars.put(ticket, car);
            return ticket;
        }
        throw new NoSpaceException();
    }

    public boolean isNotFull() {
        return this.cars.size() < size;
    }

    public boolean pick(Ticket ticket) {
        if (isContainCar(ticket)) {
            this.cars.remove(ticket);
            return true;
        }
        throw new NotExistException();
    }

    public boolean isContainCar(Ticket ticket) {
        return this.cars.containsKey(ticket);
    }

    public int restSpace() {
        return this.size - this.cars.size();
    }

    public Double restRate() {
        return (double)restSpace() / (double)this.size;
    }
}
