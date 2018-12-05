package com.jacquesvb.weather;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Map;

public class DarkSky extends WeatherHelper implements DataSource {

    @Override
    public Weather getAccuWeather() {
        return null;
    }

    @Override
    public Weather getDarkSky() throws IOException {
        Gson gson = new Gson();
        String API_KEY = "2d6c7e68e94dc2bd64001fe3ecdfcad0";
        String LATITUDE = "45.3112";
        String LONGITUDE = "-122.4055";
        String urlString = "https://api.darksky.net/forecast/" + API_KEY + "/" + LATITUDE + "," + LONGITUDE;
        String description = null;
        float current = 0f, low = 0f, high = 0f;
        StringBuilder weatherData = getData(urlString);
        Map<String, Object> weatherMap = jsonToMap(weatherData.toString());
        JsonObject jsonCurrent = gson.toJsonTree(weatherMap.get("currently")).getAsJsonObject();
        JsonObject jsonDaily = gson.toJsonTree(weatherMap.get("daily")).getAsJsonObject();

        Map<String, Object> currentData = jsonToMap(jsonCurrent.toString());
        Map<String, Object> dailyData = jsonToMap(jsonDaily.toString());

        JsonArray jsonData = gson.toJsonTree(dailyData.get("data")).getAsJsonArray();
        for (JsonElement jdata : jsonData) {
            JsonObject dataObject = jdata.getAsJsonObject();
            description = dataObject.get("summary").getAsString();
            low = dataObject.get("temperatureLow").getAsFloat();
            high = dataObject.get("temperatureHigh").getAsFloat();
        }
        current = Float.parseFloat(currentData.get("temperature").toString());

        return buildWeatherObj(description, current, low, high);
    }

    @Override
    public Weather getOpenWeathermap() {
        return null;
    }
}
