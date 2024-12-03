import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherAPI {
    private final APIClient apiClient;
    private static String response;

    public WeatherAPI(String baseUrl, String city, String country) throws IOException {
        this.apiClient = new APIClient(baseUrl);
        try {
            Location location = new Location(city, country);
            response = apiClient.getWeatherData(location.getLat(), location.getLng(), "current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,rain,snowfall,weather_code,cloud_cover,surface_pressure,wind_speed_10m,wind_direction_10m&hourly=temperature_2m,relative_humidity_2m,apparent_temperature,rain,snowfall,surface_pressure,cloud_cover,wind_speed_10m,wind_direction_10m&daily=temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,rain_sum,snowfall_sum,wind_speed_10m_max,wind_direction_10m_dominant&location_mode=csv_coordinates&csv_coordinates=,,,Europe%2FBerlin,,");
            response = response.substring(1, response.length() - 1);
        } catch(Exception e) {
                e.printStackTrace();
                throw new IOException(e.getMessage());
        }

    }

    public static CurrentData getCurrentWeather() throws IOException {
        String[] currentResponse = response.split("\\{")[2].split("\\}")[0].split(",");
        CurrentData currentData = new CurrentData(
                currentResponse[0].substring(8),
                currentResponse[2].split(":")[1],
                currentResponse[6].split(":")[1],
                currentResponse[7].split(":")[1],
                currentResponse[4].split(":")[1],
                currentResponse[11].split(":")[1],
                currentResponse[12].split(":")[1],
                currentResponse[3].split(":")[1],
                currentResponse[5].split(":")[1],
                currentResponse[9].split(":")[1],
                currentResponse[10].split(":")[1]);

        currentData.display();

        return currentData;
    }

    public List<HourlyData> getHourlyWeather() throws IOException {
        List<HourlyData> hourlyData = new ArrayList<HourlyData>();
        String[] hourlyResponse = response.split("\\{")[4].split("\\}")[0].split("],");
        String[] hourlyTime = hourlyResponse[0].substring(8).substring(1, hourlyResponse[0].substring(8).length()-1).split(",");
        String[] hourlyTemperature = hourlyResponse[1].split(":")[1].substring(1, hourlyResponse[1].split(":")[1].length()-1).split(",");
        String[] hourlyHumidity = hourlyResponse[2].split(":")[1].substring(1, hourlyResponse[2].split(":")[1].length()-1).split(",");
        String[] hourlyApparentTemperature = hourlyResponse[3].split(":")[1].substring(1, hourlyResponse[3].split(":")[1].length()-1).split(",");
        String[] hourlyRain = hourlyResponse[4].split(":")[1].substring(1, hourlyResponse[4].split(":")[1].length()-1).split(",");
        String[] hourlySnowfall = hourlyResponse[5].split(":")[1].substring(1, hourlyResponse[5].split(":")[1].length()-1).split(",");
        String[] hourlySurfacePressure = hourlyResponse[6].split(":")[1].substring(1, hourlyResponse[6].split(":")[1].length()-1).split(",");
        String[] hourlyCloudCover = hourlyResponse[7].split(":")[1].substring(1, hourlyResponse[7].split(":")[1].length()-1).split(",");
        String[] hourlyWindSpeed = hourlyResponse[8].split(":")[1].substring(1, hourlyResponse[8].split(":")[1].length()-1).split(",");
        String[] hourlyWindDirection = hourlyResponse[9].split(":")[1].substring(1, hourlyResponse[9].split(":")[1].length()-1).split(",");

        for (int i = 0; i < hourlyTime.length; i++) {
            HourlyData singleHourlyData = new HourlyData(
                    hourlyTime[i],
                    hourlyTemperature[i],
                    hourlyRain[i],
                    hourlySnowfall[i],
                    hourlyApparentTemperature[i],
                    hourlyWindSpeed[i],
                    hourlyWindDirection[i],
                    hourlyHumidity[i],
                    hourlyCloudCover[i],
                    hourlySurfacePressure[i]
            );

            hourlyData.add(singleHourlyData);
            singleHourlyData.display();
        }

        return hourlyData;
    }

    public List<DailyData> getDailyWeather() throws IOException {
        List<DailyData> dailyData = new ArrayList<DailyData>();
        String[] dailyResponse = response.split("\\{")[6].split("\\}")[0].split("],");
        String[] dailyTime = dailyResponse[0].substring(8).split(",");
        String[] dailyMaxTemperature = dailyResponse[1].split(":")[1].substring(1).split(",");
        String[] dailyMinTemperature = dailyResponse[2].split(":")[1].substring(1).split(",");
        String[] dailyMinApparentTemperature = dailyResponse[3].split(":")[1].substring(1).split(",");
        String[] dailyMaxApparentTemperature = dailyResponse[4].split(":")[1].substring(1).split(",");
        String[] dailyRainSum = dailyResponse[5].split(":")[1].substring(1).split(",");
        String[] dailySnowfallSum = dailyResponse[6].split(":")[1].substring(1).split(",");
        String[] dailyWindSpeed = dailyResponse[7].split(":")[1].substring(1).split(",");
        String[] dailyWindDirection = dailyResponse[8].split(":")[1].substring(1).split(",");

        for (int i = 0; i < dailyTime.length; i++) {
            DailyData singleDailyData = new DailyData(
                    dailyTime[i],
                    dailyMaxTemperature[i],
                    dailyRainSum[i],
                    dailySnowfallSum[i],
                    dailyMaxApparentTemperature[i],
                    dailyWindSpeed[i],
                    dailyWindDirection[i],
                    dailyMinTemperature[i],
                    dailyMinApparentTemperature[i]
            );

            dailyData.add(singleDailyData);
            singleDailyData.display();
        }

        return dailyData;
    }
}
