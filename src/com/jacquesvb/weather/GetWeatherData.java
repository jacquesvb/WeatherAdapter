package com.jacquesvb.weather;

import java.io.IOException;

public interface GetWeatherData {
    public Weather getData(String dataSource) throws IOException;
}
