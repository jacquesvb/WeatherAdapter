package com.jacquesvb.weather;

import java.io.IOException;

public class WeatherDemo {
    public static void main(String[] args) throws IOException {
        WeatherFactory weatherFactory = new WeatherFactory();

        Weather accuW;
        accuW = weatherFactory.pickSource("aw");
        System.out.println("AccuWeatherAdapter:");
        System.out.println("Description: " + accuW.getDescription());
        System.out.println("Current: " + accuW.getCurrent());
        System.out.println("High: " + accuW.getHigh());
        System.out.println("Low: " + accuW.getLow());

        Weather dSky;
        dSky = weatherFactory.getData("ds");
        System.out.println("-----------");
        System.out.println("Dark Sky");
        System.out.println("Description: " + dSky.getDescription());
        System.out.println("Current: " + dSky.getCurrent());
        System.out.println("High: " + dSky.getHigh());
        System.out.println("Low: " + dSky.getLow());

        Weather oWMap;
        oWMap = weatherFactory.getData("ow");
        System.out.println("---------");
        System.out.println("Open Weathermap");
        System.out.println("Description: " + oWMap.getDescription());
        System.out.println("Current: " + oWMap.getCurrent());
        System.out.println("High: " + oWMap.getHigh());
        System.out.println("Low: " + oWMap.getLow());
    }
}
