package com.jacquesvb.weather;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.Map;

public class AccuWeather extends WeatherHelper implements DataSource {

    @Override
    public Weather getAccuWeather() throws IOException {
        Gson gson = new Gson();
        String API_KEY = "OuUbq41YnBnFfXKcCVm6quZhbRvoADrs";
        String LOCATION = "350473";
        String forecastURL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + LOCATION + "?apikey=" + API_KEY;
        String currentURL = "http://dataservice.accuweather.com/currentconditions/v1/" + LOCATION + "?apikey=" + API_KEY;
        String description;
        float current, low, high;
        StringBuilder forecastData = getData(forecastURL);
//        StringBuilder currentData = getData(currentURL);
        Map<String, Object> forecastMap = jsonToMap(forecastData.toString());
//            Map<String, Object> currentMap = jsonToMap(currentData.toString());
        JsonArray forecastArray = gson.toJsonTree(forecastMap.get("DailyForecasts")).getAsJsonArray();
        Map<String, Object> dailyForecasts = jsonToMap(forecastArray.get(0).toString());
        Map<String, Object> temperature = jsonToMap(dailyForecasts.get("Temperature").toString());
        Map<String, Object> minTemp = jsonToMap(temperature.get("Minimum").toString());
        Map<String, Object> maxTemp = jsonToMap(temperature.get("Maximum").toString());
        System.out.println("Min temp: " + minTemp);
        String test = minTemp.get("Value").toString();
        System.out.println("Test: " + test);
        System.out.println("Low: " + Float.parseFloat(minTemp.get("Value").toString()));
        low = Float.parseFloat(minTemp.get("Value").toString());
        System.out.println("High: " + Float.parseFloat(maxTemp.get("Value").toString()));
        high = Float.parseFloat(maxTemp.get("Value").toString());
        current = 42.2f;
        description = "AccuWeather API Stinks!";

        return buildWeatherObj(description, current, low, high);
    }

    @Override
    public Weather getDarkSky() {
        return null;
    }

    @Override
    public Weather getOpenWeathermap() {
        return null;
    }
}
