package OpenWeathermap;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenWeathermapGETRequestExample {

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>(){}.getType()
        );
        return map;
    }

    public static void main(String[] args) {
        String API_KEY = "812e42062b2c5a5f1e25ad763e821621";
        String LOCATION = "Portland";
        String LATITUDE = "45.51179";
        String LONGITUDE = "-122.6756";
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?lat=" + LATITUDE + "&lon=" + LONGITUDE
                + "&appid=" + API_KEY + "&units=imperial";
        try {
            StringBuilder result = new StringBuilder();
            Gson gson = new Gson();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            System.out.println(result);
            Map<String, Object> respMap = jsonToMap(result.toString());
            System.out.println("Result: " + respMap);
            JsonArray listObject = gson.toJsonTree(respMap.get("list")).getAsJsonArray();
            System.out.println("List Object: " + listObject);
            Map<String, Object> listMap = jsonToMap(listObject.get(0).toString());
            System.out.println("List Map: " + listMap);
            Map<String, Object> main = jsonToMap(listMap.get("main").toString());
            System.out.println("Current temp: " + main.get("temp"));
            System.out.println("Low temp: " + main.get("temp_min"));
            System.out.println("High temp: " + main.get("temp_max"));

            JsonArray weatherObject = gson.toJsonTree(listMap.get("weather")).getAsJsonArray();
            System.out.println("Weather object: " + weatherObject);
            Map<String, Object> weather = jsonToMap(weatherObject.get(0).toString());
            System.out.println("Weather: " + weather);
            System.out.println("Current weather: " + weather.get("description"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
