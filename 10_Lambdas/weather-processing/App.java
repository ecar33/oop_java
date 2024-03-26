import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherProcessor wp = new WeatherProcessor();
        ArrayList<Weather> readings = wp.loadReadings("weather-processing/omaha.csv");
        System.out.println("Weather Readings");
        for (Weather w: readings) {
            System.out.println(w);
        }

        System.out.println("Rainy Readings");
        ArrayList<Weather> rainyTimes = wp.filter((w) -> {
            return w.getPrecipitation() > 0;
        });
        for (Weather w: rainyTimes) {
            System.out.println(w);
        }

        System.out.println("Very Rainy Readings");
        ArrayList<Weather> veryRainyTimes = wp.filter((w) -> {
            return w.getPrecipitation() >= 1.0;
        });
        for (Weather w: veryRainyTimes) {
            System.out.println(w);
        }

        System.out.println("Freezing Readings");
        ArrayList<Weather> freezingTimes = wp.filter((w) -> {
            return w.getTemp() < 32.0;
        });
        for (Weather w: freezingTimes) {
            System.out.println(w);
        }
    }
}
