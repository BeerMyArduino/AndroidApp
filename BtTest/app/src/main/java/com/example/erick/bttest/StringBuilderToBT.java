package com.example.erick.bttest;

import java.text.ParseException;

/**
 * Created by ERICK on 07.05.2017.
 */

public class StringBuilderToBT {

    /*
        'h-' — выкл тэна
        'h+' — вкл тэн
        'p-' — выкл мешалку
        'p+' — вкл мешалку
        'c...' — задать время
        't...' — задать температуру
        - на блютуз модуль

     */

    private volatile StringBuffer builderString = new StringBuffer("h-$p-$c__:__:__$t__");

    //1st symbol
    public synchronized void setHealingState(String state) {
        switch(state) {
            case "ON":
                builderString.setCharAt(1, '+');
                return;
            case "OFF": default:
                builderString.setCharAt(1, '-');
                return;
        }
    }
    public String getHealingState() {
        char state = builderString.charAt(1);
        switch (state) {
            case '+':
                return "ON";
            case '-':
                return "OFF";
            default:
                return "ERR";
        }
    }
    /*//3st symbol
    public synchronized void setPumpState(String state) {
        switch(state) {
            case "ON":
                builderString.setCharAt(3, '+');
                return;
            case "OFF": default:
                builderString.setCharAt(3, '-');
                return;
        }
    }
    public String getPumpState() {
        char state = builderString.charAt(3);
        switch (state) {
            case '+':
                return "ON";
            case '-':
                return "OFF";
            default:
                return "ERR";
        }
    }*/
    //17-18th symbols
    public synchronized void setTemperature(Integer temperature) {
        String temperatureString = temperature.toString();
        if (Integer.parseInt(temperatureString) > 90) {
            System.out.println(temperatureString);
            temperatureString = "90";
        }
        builderString.setCharAt(17, temperatureString.charAt(0));
        builderString.setCharAt(18, temperatureString.charAt(1));
    }
    public Integer getTemperature() throws ParseException{
        return Integer.parseInt(builderString.substring(17));
    }
    //7-8th - hours, 10-11th - minutes, 13-14th - secs
    public synchronized void setTime(String time) {
        String[] times = time.split("[^A-Za-z0-9]");
        switch(times.length) {
            case 1:
                builderString.setCharAt(7, '0');
                builderString.setCharAt(8, '0');
                builderString.setCharAt(10, '0');
                builderString.setCharAt(11, '0');
                if (times[0].length() == 1) {
                    times[0] = new StringBuilder(times[0].concat("0")).reverse().toString();
                }
                builderString.setCharAt(13, times[0].charAt(0));
                builderString.setCharAt(14, times[0].charAt(1));
                return;
            case 2:
                builderString.setCharAt(7, '0');
                builderString.setCharAt(8, '0');
                if (times[0].length() == 1) {
                    times[0] = new StringBuilder(times[0].concat("0")).reverse().toString();
                }
                builderString.setCharAt(10, times[0].charAt(0));
                builderString.setCharAt(11, times[0].charAt(1));
                if (times[1].length() == 1) {
                    times[1] = new StringBuilder(times[1].concat("0")).reverse().toString();
                }
                builderString.setCharAt(13, times[1].charAt(0));
                builderString.setCharAt(14, times[1].charAt(1));
                return;
            case 3:
                if (times[0].length() == 1) {
                    times[0] = new StringBuilder(times[0].concat("0")).reverse().toString();
                }
                builderString.setCharAt(7, times[0].charAt(0));
                builderString.setCharAt(8, times[0].charAt(1));
                if (times[1].length() == 1) {
                    times[1] = new StringBuilder(times[1].concat("0")).reverse().toString();
                }
                builderString.setCharAt(10, times[1].charAt(0));
                builderString.setCharAt(11, times[1].charAt(1));
                if (times[2].length() == 1) {
                    times[2] = new StringBuilder(times[2].concat("0")).reverse().toString();
                }
                builderString.setCharAt(13, times[2].charAt(0));
                builderString.setCharAt(14, times[2].charAt(1));
                return;
        }
    }
    public String getTime() {
        return builderString.substring(7, 15);
    }
    public String getAll() {
        return builderString.toString();
    }
}
