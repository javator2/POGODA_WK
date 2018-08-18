import model.Weather;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        WeatherService weatherService = new WeatherService("https://api.apixu.com/v1/current.json", "b1f7808034d6412882272101181808");

        //String url = "https://api.apixu.com/v1/current.json?key=b1f7808034d6412882272101181808&q=Torun";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta: ");
        String cityName = scanner.nextLine();


       Weather weather = weatherService.getCityWeather(cityName);



        System.out.println(weatherService.getCityWeather(cityName).toString());
        String url = "http://maps.googleapis.com/maps/api/staticmap?center=" + weather.getLat()+ "," + weather.getLon() +"&size=400x400&zoom=10";

        File file = new File("plik.jpg");
        deleteFile(file);


        try (InputStream input = new URL(url).openStream()) {
            Files.copy(input, Paths.get("plik.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* try {
            //System.out.println(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));

            JSONObject json = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));

            //System.out.println(json.getJSONObject("current").get("temp_c"));
            //System.out.println(json.getJSONObject("current").get("last_updated"));
            //System.out.println(json.getJSONObject("current").getJSONObject("condition").get("text"));

            Weather weather = new Weather();
            weather.setCity(json.getJSONObject("location").get("name").toString());
            weather.setConditionText(json.getJSONObject("current").getJSONObject("condition").get("text").toString());
            weather.setTemperature((Double) json.getJSONObject("current").get("temp_c"));
            weather.setFeelslikeC((Double) json.getJSONObject("current").get("feelslike_c"));
            weather.setIconURL((String) json.getJSONObject("current").getJSONObject("condition").get("icon"));

            System.out.println(weather.toString());

            Iterator<String> keys = json.getJSONObject("current").keys();

            for (Iterator<String> it = keys; it.hasNext(); ) {
                String k = it.next();
                System.out.println(k);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }

    private static void deleteFile(File file) {
        if(file.delete()){
            System.out.println("Skasowano plik");
        }else {
            System.out.println("Nie udało sie skasowac pliku");
        }
    }
}
