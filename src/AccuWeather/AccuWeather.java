package AccuWeather;

public class AccuWeather {

    private String LocalObservationDateTime;
    private int EpochTime;
    private String WeatherText;
    private int WeatherIcon;
    private boolean HasPreceipitation;
    private String PrecipitationType;
    private boolean IsDayTime;
    private Temperature Temperature;
    private String MobileLink;
    private String Link;

    public String getLocalObservationDateTime() {
        return LocalObservationDateTime;
    }

    public int getEpochTime() {
        return EpochTime;
    }

    public String getWeatherText() {
        return WeatherText;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public boolean isHasPreceipitation() {
        return HasPreceipitation;
    }

    public String getPrecipitationType() {
        return PrecipitationType;
    }

    public boolean isDayTime() {
        return IsDayTime;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public String getLink() {
        return Link;
    }

    @Override
    public String toString() {
        return "AccuWeatherAdapter{" +
                "LocalObservationDateTime='" + LocalObservationDateTime + '\'' +
                ", EpochTime=" + EpochTime +
                ", WeatherText='" + WeatherText + '\'' +
                ", WeatherIcon=" + WeatherIcon +
                ", HasPreceipitation=" + HasPreceipitation +
                ", PrecipitationType='" + PrecipitationType + '\'' +
                ", IsDayTime=" + IsDayTime +
                ", Temperature=" + Temperature +
                ", MobileLink='" + MobileLink + '\'' +
                ", Link='" + Link + '\'' +
                '}';
    }
}

