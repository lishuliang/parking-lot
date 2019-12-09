package com.example.demo;

import com.example.demo.length.Length;
import com.example.demo.length.LengthUtil;
import com.example.demo.length.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthUtilTest {

    private LengthUtil lengthUtil;

    @BeforeEach
    void setUp() {
        lengthUtil = new LengthUtil();
    }


    @Test
    void should_return_0_when_given_1cm_and_1cm() {
        Length first = new Length(1, Unit.CM);
        Length second = new Length(1, Unit.CM);

        assertEquals(lengthUtil.compare(first, second), 0);
    }

    @Test
    void should_return_1_when_given_2cm_and_1cm() {
        Length first = new Length(2, Unit.CM);
        Length second = new Length(1, Unit.CM);

        assertEquals(lengthUtil.compare(first, second), 1);
    }

    @Test
    void should_return__1_when_given_1cm_and_2cm() {
        Length first = new Length(1, Unit.CM);
        Length second = new Length(2, Unit.CM);

        assertEquals(lengthUtil.compare(first, second), -1);
    }

    @Test
    void should_return_0_when_given_100cm_and_1m() {
        Length first = new Length(100, Unit.CM);
        Length second = new Length(1, Unit.M);

        assertEquals(lengthUtil.compare(first, second), 0);
    }

    @Test
    void should_return_100_when_given_2m_and_100cm() {
        Length first = new Length(2, Unit.M);
        Length second = new Length(100, Unit.CM);

        assertEquals(lengthUtil.compare(first, second), 100);
    }

    @Test
    void should_return_0_when_given_2m_and_2m() {
        Length first = new Length(2, Unit.M);
        Length second = new Length(2, Unit.M);

        assertEquals(lengthUtil.compare(first, second), 0);
    }

    @Test
    void should_return__100_when_given_1m_and_2m() {
        Length first = new Length(1, Unit.M);
        Length second = new Length(2, Unit.M);

        assertEquals(lengthUtil.compare(first, second), -100);
    }
}
