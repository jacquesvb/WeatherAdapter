package DarkSky;

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
import java.util.Map;

public class DarkSkyGETRequestExample {

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>(){}.getType()
        );
        return map;
    }

    public static void main(String[] args) {
        String API_KEY = "2d6c7e68e94dc2bd64001fe3ecdfcad0";
        String LATITUDE = "45.3112";
        String LONGITUDE = "-122.4055";
        String urlString = "https://api.darksky.net/forecast/" + API_KEY + "/" + LATITUDE + "," + LONGITUDE;

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

            Map<String, Object> mainMap = jsonToMap(result.toString());
            JsonObject jsonCurrent = gson.toJsonTree(mainMap.get("currently")).getAsJsonObject();
            JsonObject jsonDaily = gson.toJsonTree(mainMap.get("daily")).getAsJsonObject();

            Map<String, Object> current = jsonToMap(jsonCurrent.toString());
            Map<String, Object> daily = jsonToMap(jsonDaily.toString());
            System.out.println("Daily: " + daily);
            System.out.println("Data: " + daily.get("data"));

            JsonArray jsonData = gson.toJsonTree(daily.get("data")).getAsJsonArray();
//            Map<String, Object> data = jsonToMap(daily.get("data").toString());
            String summary = null;
            Float lowTemp = null;
            Float highTemp = null;
            Float precipitation = null;
            for (JsonElement jdata : jsonData) {
                JsonObject dataObject = jdata.getAsJsonObject();
                summary = dataObject.get("summary").getAsString();
                lowTemp = dataObject.get("temperatureLow").getAsFloat();
                highTemp = dataObject.get("temperatureHigh").getAsFloat();
                precipitation = dataObject.get("precipIntensity").getAsFloat();
            }
            Boolean isRaining = false;
            if (precipitation > 0) {
                isRaining = true;
            }
            System.out.println("Current conditions: " + summary);
            System.out.println("Current temperature: " + current.get("temperature"));
            System.out.println("Low temperature: " + lowTemp);
            System.out.println("High temperature: " + highTemp);
            System.out.println("Is it raining? " + isRaining);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
