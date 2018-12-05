package AccuWeather;

public class Imperial {

    private int value;
    private String unit;
    private int unitType;

    public int getValue() {
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
        return "Imperial{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                ", unitType=" + unitType +
                '}';
    }
}
