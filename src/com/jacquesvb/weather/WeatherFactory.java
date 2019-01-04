package com.jacquesvb.weather;

import java.io.IOException;

public class WeatherFactory implements GetWeatherData, IAccuWeather, IDarkSky, IOpenWeathermap {
    IDarkSky iDarkSky;
    IOpenWeathermap iOpenWeathermap;

    public IAccuWeather pickSource(String source) {
        if(source.equalsIgnoreCase("aw")) {
            OpenWeathermapAdapter();
            return iAccuWeather;
        } else if (source.equalsIgnoreCase("ds")) {
            iDarkSky = new DarkSkyAdapter();
        } else if (source.equalsIgnoreCase("ow")) {
            iOpenWeathermap = new OpenWeathermapAdapter();
        }
        return null;
    }

    @Override
    public Weather getData(String dataSource) throws IOException {
        return null;
    }

    @Override
    public Weather getAccuWeather() throws IOException {
        return null;
    }

    @Override
    public Weather getDarkSky() throws IOException {
        return null;
    }

    @Override
    public Weather getOpenWeathermap() throws IOException {
        return null;
    }
}
