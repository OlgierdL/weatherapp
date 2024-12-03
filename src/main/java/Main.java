import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        //test
        WeatherAPI weatherApi = new WeatherAPI("https://api.open-meteo.com/v1/forecast", "Poznan", "Poland");
        System.out.println("\nCurrent:");
        CurrentData current = WeatherAPI.getCurrentWeather();
        System.out.println("\nHourly:");
        List<HourlyData> hourly = weatherApi.getHourlyWeather();
        System.out.println("\nDaily:");
        List<DailyData> daily = weatherApi.getDailyWeather();
    }
}
