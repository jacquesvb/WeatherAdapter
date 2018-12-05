package DarkSky;

public class CurrentWeather {
    Long time;
    String summary;
    String icon;
    Float nearestStormDistance;
    Float nearestStormBearing;
    Float precipIntensity;
    Float precipProbability;
    Float temperature;
    Float apparentTemperature;
    Float dewPoint;
    Float humidity;
    Float pressure;
    Float windSpeed;
    Float windGust;
    Float windBearing;
    Float cloudCover;
    Float uvIndex;
    Float visibility;
    Float ozone;

    public CurrentWeather() {}

    public CurrentWeather(Long time, String summary, String icon, Float nearestStormDistance, Float nearestStormBearing, Float precipIntensity, Float precipProbability, Float temperature, Float apparentTemperature, Float dewPoint, Float humidity, Float pressure, Float windSpeed, Float windGust, Float windBearing, Float cloudCover, Float uvIndex, Float visibility, Float ozone) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.nearestStormDistance = nearestStormDistance;
        this.nearestStormBearing = nearestStormBearing;
        this.precipIntensity = precipIntensity;
        this.precipProbability = precipProbability;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
        this.ozone = ozone;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "time=" + time +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", nearestStormDistance=" + nearestStormDistance +
                ", nearestStormBearing=" + nearestStormBearing +
                ", precipIntensity=" + precipIntensity +
                ", precipProbability=" + precipProbability +
                ", temperature=" + temperature +
                ", apparentTemperature=" + apparentTemperature +
                ", dewPoint=" + dewPoint +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", windGust=" + windGust +
                ", windBearing=" + windBearing +
                ", cloudCover=" + cloudCover +
                ", uvIndex=" + uvIndex +
                ", visibility=" + visibility +
                ", ozone=" + ozone +
                '}';
    }
}
