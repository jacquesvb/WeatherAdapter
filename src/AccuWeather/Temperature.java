package AccuWeather;

public class Temperature {

    private Metric metric;
    private Imperial imperial;

    public Metric getMetric() {
        return metric;
    }

    public Imperial getImperial() {
        return imperial;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "metric=" + metric +
                ", imperial=" + imperial +
                '}';
    }
}
