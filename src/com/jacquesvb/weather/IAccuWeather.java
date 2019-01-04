package com.jacquesvb.weather;

import java.io.IOException;

public interface IAccuWeather {
    Weather getAccuWeather() throws IOException;
}
