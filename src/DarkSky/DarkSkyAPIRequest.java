package DarkSky;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import tk.plogitech.darksky.forecast.*;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DarkSkyAPIRequest {

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>(){}.getType()
        );
        return map;
    }

    public static void main(String[] args) throws ForecastException {

        String API_KEY = "2d6c7e68e94dc2bd64001fe3ecdfcad0";
        Double LATITUDE = 45.3112;
        Double LONGITUDE = -122.4055;
        String urlString = "https://api.darksky.net/forecast/" + API_KEY + "/" + LATITUDE + "," + LONGITUDE;

        ForecastRequest request = new ForecastRequestBuilder().key(new APIKey(API_KEY))
                .location(new GeoCoordinates(new Longitude(LONGITUDE), new Latitude(LATITUDE))).language(ForecastRequestBuilder.Language.en).build();

        DarkSkyClient client = new DarkSkyClient();
        String forecast = client.forecastJsonString(request);
        System.out.println(forecast);
        Map<String, Object> mainMap = jsonToMap(forecast);
        for (String key : mainMap.keySet()) {
            System.out.println(key);
        }
        System.out.println(mainMap.containsKey("currently"));
        System.out.println(mainMap.get("currently"));
        Gson gson = new Gson();
        JsonObject jsonObject = gson.toJsonTree(mainMap.get("currently")).getAsJsonObject();
        System.out.println("This thing: " + jsonObject);
        System.out.println("This should be the weather: " + jsonObject.get("summary").toString());
        Map<String, Object> current = jsonToMap(jsonObject.toString());
        System.out.println("Now it is: " + current.get("summary"));
//        List<CurrentWeather> current = mainMap.get("currently");
//        current.stream().flatMap(mainMap.get("currently")).collect(Collectors.toList());
//        Map<String, Object> current = jsonToMap(mainMap.get("currently").toString());
//        System.out.println("Current: " + current);
//        System.out.println("The weather is: " + current.get("summary"));
    }
}
