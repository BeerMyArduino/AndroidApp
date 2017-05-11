package com.example.erick.breweryappnew;

import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;

/**
 * Created by ERICK on 11.05.2017.
 */

public class StringBuilderFromBT {
    /*
        нижняя_температура   верхняя_температура   время_с_начала_варки_на_нужной_температуре  
        необходимая_температура   необходимое_время_варки   включен_ли_ТЭН (0/1)   включен_ли_насос
        - на блютуз модуль
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
        return builderString.toString().split(" ")[2];
    }
    public Integer getMaxTemperature() {
        return Integer.parseInt(builderString.toString().split(" ")[3]);
    }
    public String getMaxTime() {
        return builderString.toString().split(" ")[4];
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
