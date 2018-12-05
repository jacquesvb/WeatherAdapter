package AccuWeather;

public class Metric {
    private float value;
    private String unit;
    private int unitType;

    public float getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public int getUnitType() {
        return unitType;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                ", unitType=" + unitType +
                '}';
    }
}
