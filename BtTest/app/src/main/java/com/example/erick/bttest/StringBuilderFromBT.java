package com.example.erick.bttest;

import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;

/**
 * Created by ERICK on 11.05.2017.
 */

public class StringBuilderFromBT {
    /*
        нижняя_температура верхняя_температура время_с_начала_варки_на_нужной_температуре
        необходимая_температура необходимое_время_варки включен_ли_ТЭН(0/1) включен_ли_насос(0/1)
        - с блютуз модуля
     */

    private StringBuffer builderString;

    public StringBuilderFromBT(String arduinoInfo) {
        builderString = new StringBuffer(arduinoInfo);
    }
    public Integer getBotTemperature() {
        return Integer.parseInt(builderString.toString().split(" ")[0]);
    }
    public Integer getTopTemperature() {
        return Integer.parseInt(builderString.toString().split(" ")[1]);
    }
    public String getLeftTime() {
        StringBuilder formingString = new StringBuilder("00:00:00");
        Integer formingTime = Integer.parseInt(builderString.toString().split(" ")[2]),
                hours = formingTime / 3600, minutes = (formingTime - hours * 3600) / 60,
                seconds = formingTime  - (hours * 3600 + minutes * 60);
        System.out.println(hours + " " + minutes + " " + seconds);
        if (hours > 0) {
            formingString.replace((hours > 9) ? 0 : 1, 2, hours.toString());
        } else if (minutes > 0) {
            formingString.replace((minutes > 9) ? 3 : 4, 5, minutes.toString());
        } else if (seconds > 0) {
            formingString.replace((seconds > 9) ? 6 : 7, 8, seconds.toString());
        }

        return formingString.toString();
    }
    public Integer getMaxTemperature() {
        return Integer.parseInt(builderString.toString().split(" ")[3]);
    }
    public String getMaxTime() {
        StringBuilder formingString = new StringBuilder("00:00:00");
        Integer formingTime = Integer.parseInt(builderString.toString().split(" ")[4]),
                hours = formingTime / 3600, minutes = (formingTime - hours * 3600) / 60,
                seconds = formingTime  - (hours * 3600 + minutes * 60);
        System.out.println(hours + " " + minutes + " " + seconds);
        if (hours > 0) {
            formingString.replace((hours > 9) ? 0 : 1, 2, hours.toString());
        } else if (minutes > 0) {
            formingString.replace((minutes > 9) ? 3 : 4, 5, minutes.toString());
        } else if (seconds > 0) {
            formingString.replace((seconds > 9) ? 6 : 7, 8, seconds.toString());
        }

        return formingString.toString();
    }
    public Boolean getHealingElementState() throws NumberFormatException {
        switch(builderString.toString().split(" ")[5]) {
            case "0":
                return false;
            case "1":
                return true;
            default:
                throw new NumberFormatException();
        }
    }
    public Boolean getPumpState() throws NumberFormatException {
        switch(builderString.toString().split(" ")[6]) {
            case "0":
                return false;
            case "1":
                return true;
            default:
                throw new NumberFormatException();
        }
    }
}

