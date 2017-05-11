package com.example.erick.breweryappnew;

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
        - с блютуз модуля

     */

    private volatile StringBuffer builderString = new StringBuffer("h-$p-$c'__:__:__'$t'__'");

    //1st symbol
    public synchronized void setHealingState(String state) {
        switch(state) {
            case "ON":
                builderString.setCharAt(1, '+');
                return;
            case "OFF":
                builderString.setCharAt(1, '-');
                return;
            default:
                //TODO: get from last bt message current healing element state
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
    //21-22th symbols
    public synchronized void setTemperature(Integer temperature) {
        String temperatureString = temperature.toString();
        if (temperatureString.length() > 2) {
            System.out.println(temperatureString);
            temperatureString = temperatureString.substring(0, 1);
        }
        builderString.setCharAt(20, temperatureString.charAt(0));
        builderString.setCharAt(21, temperatureString.charAt(1));
    }
    public Integer getTemperature() throws ParseException{
        return Integer.parseInt(builderString.substring(20, 22));
    }
    //8-9th - hours, 11-12th - minutes, 14-15th - secs
    public synchronized void setTime(String time) {
        String[] times = time.split("[^A-Za-z0-9]");
        switch(times.length) {
            case 1:
                builderString.setCharAt(8, '0');
                builderString.setCharAt(9, '0');
                builderString.setCharAt(11, '0');
                builderString.setCharAt(12, '0');
                if (times[0].length() == 1) {
                    times[0] = new StringBuilder(times[0].concat("0")).reverse().toString();
                }
                builderString.setCharAt(14, times[0].charAt(0));
                builderString.setCharAt(15, times[0].charAt(1));
                return;
            case 2:
                builderString.setCharAt(8, '0');
                builderString.setCharAt(9, '0');
                if (times[0].length() == 1) {
                    times[0] = new StringBuilder(times[0].concat("0")).reverse().toString();
                }
                builderString.setCharAt(11, times[0].charAt(0));
                builderString.setCharAt(12, times[0].charAt(1));
                if (times[1].length() == 1) {
                    times[1] = new StringBuilder(times[1].concat("0")).reverse().toString();
                }
                builderString.setCharAt(14, times[1].charAt(0));
                builderString.setCharAt(15, times[1].charAt(1));
                return;
            case 3:
                if (times[0].length() == 1) {
                    times[0] = new StringBuilder(times[0].concat("0")).reverse().toString();
                }
                builderString.setCharAt(8, times[0].charAt(0));
                builderString.setCharAt(9, times[0].charAt(1));
                if (times[1].length() == 1) {
                    times[1] = new StringBuilder(times[1].concat("0")).reverse().toString();
                }
                builderString.setCharAt(11, times[1].charAt(0));
                builderString.setCharAt(12, times[1].charAt(1));
                if (times[2].length() == 1) {
                    times[2] = new StringBuilder(times[2].concat("0")).reverse().toString();
                }
                builderString.setCharAt(14, times[2].charAt(0));
                builderString.setCharAt(15, times[2].charAt(1));
                return;
        }
    }
    public String getTime() {
        return builderString.substring(8, 16);
    }
    public String getAll() {
        return builderString.toString();
    }
}
