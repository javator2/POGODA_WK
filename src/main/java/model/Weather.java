package model;

public class Weather {

    private String city;
    private String iconURL;
    private double temperature;
    private double feelslikeC;
    private String conditionText;
    private double lat;
    private double lon;


    public Weather() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", iconURL='" + iconURL + '\'' +
                ", temperature=" + temperature +
                ", feelslikeC=" + feelslikeC +
                ", conditionText='" + conditionText + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
