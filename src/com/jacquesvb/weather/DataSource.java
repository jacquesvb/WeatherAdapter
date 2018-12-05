package com.jacquesvb.weather;

import java.io.IOException;

public interface DataSource {

    public Weather getAccuWeather() throws IOException;
    public Weather getDarkSky() throws IOException;
    public Weather getOpenWeathermap() throws IOException;
}
