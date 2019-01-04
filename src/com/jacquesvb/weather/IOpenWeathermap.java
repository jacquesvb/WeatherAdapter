package com.jacquesvb.weather;

import java.io.IOException;

public interface IOpenWeathermap {
    Weather getOpenWeathermap() throws IOException;
}
