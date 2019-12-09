package com.example.demo.length;

public class Length {

    private int value;
    private Unit unit;

    public Length(int value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }
}
