package com.jacquesvb.weather;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.Map;

public class OpenWeathermapAdapter extends WeatherHelper implements IOpenWeathermap {

    @Override
    public Weather getOpenWeathermap() throws IOException {
        Gson gson = new Gson();
        String API_KEY = "812e42062b2c5a5f1e25ad763e821621";
        String LATITUDE = "45.51179";
        String LONGITUDE = "-122.6756";
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?lat=" + LATITUDE + "&lon=" + LONGITUDE
                + "&appid=" + API_KEY + "&units=imperial";
        String description;
        float current, low, high;
        StringBuilder weatherData = getData(urlString);
        Map<String, Object> weatherMap = jsonToMap(weatherData.toString());
        JsonArray listObject = gson.toJsonTree(weatherMap.get("list")).getAsJsonArray();
        Map<String, Object> listMap = jsonToMap(listObject.get(0).toString());
        Map<String, Object> main = jsonToMap(listMap.get("main").toString());

        current = Float.parseFloat(main.get("temp").toString());
        low = Float.parseFloat(main.get("temp_min").toString());
        high = Float.parseFloat(main.get("temp_max").toString());

        JsonArray weatherObject = gson.toJsonTree(listMap.get("weather")).getAsJsonArray();
        Map<String, Object> weather = jsonToMap(weatherObject.get(0).toString());
        description = weather.get("description").toString();

        return buildWeatherObj(description, current, low, high);
    }
}
