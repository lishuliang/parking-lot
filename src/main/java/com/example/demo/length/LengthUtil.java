package com.example.demo.length;

public class LengthUtil {
    public int compare(Length first, Length second) {
        Length transformedFirst = transform(first);
        Length transformedSecond = transform(second);
        return transformedFirst.getValue() - transformedSecond.getValue();
    }

    private Length transform(Length length) {
        if(length.getUnit().equals(Unit.M)) {
            return new Length(length.getValue() * 100, Unit.CM);
        }
        return length;
    }
}
