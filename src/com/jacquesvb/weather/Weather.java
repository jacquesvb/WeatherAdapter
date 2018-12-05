package com.jacquesvb.weather;

public class Weather {

    private String description;
    private float current;
    private float low;
    private float high;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                ", current=" + current +
                ", low=" + low +
                ", high=" + high +
                '}';
    }
}
