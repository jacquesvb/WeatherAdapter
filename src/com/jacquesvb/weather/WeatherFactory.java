package com.jacquesvb.weather;

import java.io.IOException;

public class WeatherFactory implements GetWeatherData {

    WeatherAdapter weatherAdapter;

    @Override
    public Weather getData(String dataSource) throws IOException {

        if(dataSource.equalsIgnoreCase("aw") || dataSource.equalsIgnoreCase("ds") ||
                dataSource.equalsIgnoreCase("ow")) {
            weatherAdapter = new WeatherAdapter(dataSource);
            return weatherAdapter.getData(dataSource);
        } else {
            System.out.println("Invalid Data Source");
        }
        return null;
    }
}
