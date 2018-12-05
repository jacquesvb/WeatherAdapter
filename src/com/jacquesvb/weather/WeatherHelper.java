package com.jacquesvb.weather;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WeatherHelper {

    public StringBuilder getData(String aURL) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(aURL);
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result;
    }

    public Weather buildWeatherObj(String description, float current, float low, float high) {
        Weather weather = new Weather();
        weather.setDescription(description);
        weather.setCurrent(current);
        weather.setLow(low);
        weather.setHigh(high);

        return weather;
    }

    public Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>(){}.getType()
        );
        return map;
    }
}
