package com.example.erick.bttest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ERICK on 11.05.2017.
 */

/**
 *нижняя_температура верхняя_температура время_с_начала_варки_на_нужной_температуре
 *необходимая_температура необходимое_время_варки включен_ли_ТЭН (0/1) включен_ли_насос(0/1)
 *- c блютуз модуля
 */

public class StringBuilderFromBTTest {
    StringBuilderFromBT testClass;

    @Before
    public void setInfo() throws Exception {
        testClass = new StringBuilderFromBT("56 67 882 80 3610 1 0");
    }

    @Test
    public void getBotTemperature() throws Exception {
        assertEquals(testClass.getBotTemperature(), 56, 1.0e0);
    }

    @Test
    public void getTopTemperature() throws Exception {
        assertEquals(testClass.getTopTemperature(), 67, 1.0e0);
    }

    @Test
    public void getLeftTime() throws Exception {
        assertEquals(testClass.getLeftTime(), "00:14:42");
    }

    @Test
    public void getMaxTemperature() throws Exception {
        assertEquals(testClass.getMaxTemperature(), 80, 1.0e0);
    }

    @Test
    public void getMaxTime() throws Exception {
        assertEquals(testClass.getMaxTime(), "01:00:00");
    }

    @Test
    public void getHealingElementState() throws Exception {
        assertTrue(testClass.getHealingElementState());
    }

    @Test
    public void getPumpState() throws Exception {
        assertFalse(testClass.getPumpState());
    }

}