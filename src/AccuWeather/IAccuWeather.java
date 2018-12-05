package AccuWeather;

public interface IAccuWeather {
    String weatherText();
    Boolean hasPrecipitation();
    String precipitationType();
    Boolean isDayTime();
    Float metricValue();
    String metricUnit();
    Integer imperialValue();
    String imperialUnit();
}
