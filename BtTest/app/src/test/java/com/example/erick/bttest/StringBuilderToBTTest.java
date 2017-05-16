package com.example.erick.bttest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ERICK on 10.05.2017.
 */
public class StringBuilderToBTTest {
    private StringBuilderToBT testClass;

    @Before
    public void init() throws NullPointerException {
        testClass = new StringBuilderToBT();
    }

    @Test
    public void getHealingStateOn() throws Exception {
        testClass.setHealingState("ON");
        assertEquals(testClass.getHealingState(), "ON");
    }
    @Test
    public void getHealingStateOff() throws Exception {
        testClass.setHealingState("OFF");
        assertEquals(testClass.getHealingState(), "OFF");
    }
    @Test
    public void getPumpStateOn() throws Exception {
        testClass.setPumpState("ON");
        assertEquals(testClass.getPumpState(), "ON");
    }
    @Test
    public void getPumpStateOff() throws Exception {
        testClass.setPumpState("OFF");
        assertEquals(testClass.getPumpState(), "OFF");
    }
    @Test
    public void getTemperature() throws Exception {
        testClass.setTemperature(80);
        System.out.println(testClass.getAll());
        System.out.println(testClass.getTemperature());
        assertEquals(testClass.getTemperature(), 80.0, 1.0e0);
    }

    @Test
    public void getTime1() throws Exception {
        testClass.setTime("1:20;30");
        System.out.println(testClass.getAll());
        assertEquals(testClass.getTime(), "01:20:30");
    }
    @Test
    public void getTime2() throws Exception {
        testClass.setTime("01.30");
        System.out.println(testClass.getAll());
        assertEquals(testClass.getTime(), "00:01:30");
    }
    @Test
    public void getTime3() throws Exception {
        testClass.setTime("00/10/00");
        System.out.println(testClass.getAll());
        assertEquals(testClass.getTime(), "00:10:00");
    }
    @Test
    public void getTime4() throws Exception {
        testClass.setTime("1");
        System.out.println(testClass.getAll());
        assertEquals(testClass.getTime(), "00:00:01");
    }

}