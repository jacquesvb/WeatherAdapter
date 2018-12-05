package com.jacquesvb.weather;

import java.io.IOException;

public class WeatherAdapter implements GetWeatherData {

    DataSource dataSource;

    public WeatherAdapter(String source) {
        if(source.equalsIgnoreCase("aw")) {
            dataSource = new AccuWeather();
        } else if (source.equalsIgnoreCase("ds")) {
            dataSource = new DarkSky();
        } else if (source.equalsIgnoreCase("ow")) {
            dataSource = new OpenWeathermap();
        }
    }

    @Override
    public Weather getData(String source) throws IOException {
        if(source.equalsIgnoreCase("aw")) {
            return dataSource.getAccuWeather();
        } else if(source.equalsIgnoreCase("ds")) {
           return  dataSource.getDarkSky();
        } else if(source.equalsIgnoreCase("ow")) {
            return dataSource.getOpenWeathermap();
        }
        return null;
    }
}
