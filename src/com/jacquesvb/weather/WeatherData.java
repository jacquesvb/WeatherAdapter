package com.jacquesvb.weather;

public interface WeatherData {
    Weather getAccuWeather();
    Weather getDarkSky();
    Weather getOpenWeathermap();
}
