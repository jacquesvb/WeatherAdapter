package AccuWeather;

import AccuWeather.AccuWeather;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AWData {

    String API_KEY = "OuUbq41YnBnFfXKcCVm6quZhbRvoADrs";
    String LOCATION = "350473";
    String urlString = "http://dataservice.accuweather.com/currentconditions/v1/" + LOCATION + "?apikey=" + API_KEY;
    byte[] awData;
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    List<AccuWeather> aw;
    public AccuWeather getWeatherData() {
        InputStream is = null;
        try {
            StringBuilder weatherData = new StringBuilder();
            URL url = new URL(urlString);
//            URLConnection urlCon = url.openConnection();
//            InputStream inputStream = urlCon.getInputStream();
//            byte[] data = new byte[1024];
//            inputStream.read(data);
//            ObjectMapper objectMapper = new ObjectMapper();
//            AccuWeather accuWeather = objectMapper.readValue(inputStream, AccuWeather.class);
//            System.out.println("Object Mapper: " + accuWeather);
//            int n;
//            while((n = is.read(jsonData)) > 0) {
//                baos.write(jsonData, 0, n);
//            }
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = rd.readLine()) != null) {
                weatherData.append(line);
            }
            System.out.println("This is it: " + weatherData);
            rd.close();
//            TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String, Object>>() {};
//            HashMap<String,Object> o = mapper.readValue(String.valueOf(weatherData), typeRef);
//            System.out.println("Hash Mappy: " + o);
//            aw = mapper.readValue(awData, new TypeReference<List<AccuWeather>>(){});
            AccuWeather aw = mapper.readValue(String.valueOf(weatherData), new TypeReference<AccuWeather>(){});
            System.out.println("This is what is what: " + aw);
            return aw;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
