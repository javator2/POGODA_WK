import model.Weather;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String finalUrl;

    public WeatherService(String url, String apiKey) {
        finalUrl = url + "?key=" + apiKey;

    }

    public Weather getCityWeather(String city) {
        Weather weather = new Weather();
        String reqUrl = finalUrl + "&q=" + city;

        JSONObject json = null;

        try {
            json = new JSONObject(IOUtils.toString(new URL(reqUrl), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        weather.setCity(json.getJSONObject("location").get("name").toString());
        weather.setConditionText(json.getJSONObject("current").getJSONObject("condition").get("text").toString());
        weather.setTemperature((Double) json.getJSONObject("current").get("temp_c"));
        weather.setFeelslikeC((Double) json.getJSONObject("current").get("feelslike_c"));
        weather.setIconURL((String) json.getJSONObject("current").getJSONObject("condition").get("icon"));
        weather.setLat(json.getJSONObject("location").getDouble("lat"));
        weather.setLon(json.getJSONObject("location").getDouble("lon"));

        return weather;
    }
}



