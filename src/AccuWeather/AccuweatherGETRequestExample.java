package AccuWeather;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class AccuweatherGETRequestExample {

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>(){}.getType()
        );
        return map;
    }

    public static void main(String[] args) {
        String API_KEY = "OuUbq41YnBnFfXKcCVm6quZhbRvoADrs";
        String LOCATION = "350473";
        String forecastURL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + LOCATION + "?apikey=" + API_KEY;
        String currentURL = "http://dataservice.accuweather.com/currentconditions/v1/" + LOCATION + "?apikey=" + API_KEY;
        try {
            StringBuilder result = new StringBuilder();
            Gson gson = new Gson();
            URL url = new URL(currentURL);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            System.out.println("Result: " + result);
            JsonParser parser = new JsonParser();
            JsonElement jsonTree = parser.parse(result.toString());
            System.out.println("JSON Tree: " + jsonTree);
            Map<String, Object> boogie = jsonToMap(jsonTree.toString());
            System.out.println("JSON Object: " + boogie);
            // Code for currentURL

            // Code for forecastURL
//            JsonArray dfArray = gson.toJsonTree(mainMap.get("DailyForecasts")).getAsJsonArray();
//            Map<String, Object> dailyForecasts = jsonToMap(dfArray.get(0).toString());
//            Map<String, Object> temperature = jsonToMap(dailyForecasts.get("Temperature").toString());
//            Map<String, Object> minTemp = jsonToMap(temperature.get("Minimum").toString());
//            Map<String, Object> maxTemp = jsonToMap(temperature.get("Maximum").toString());
//            System.out.println("Low: " + minTemp.get("Value") + minTemp.get("Unit"));
//            System.out.println("High: " + maxTemp.get("Value") + maxTemp.get("Unit"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
