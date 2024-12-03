public class DailyData extends WeatherData {
    private final String maxTemperature;
    private final String minTemperature;
    private final String maxApparentTemperature;
    private final String minApparentTemperature;

    public DailyData(String time, String temperature, String rain, String snowfall, String apparentTemperature, String windSpeed, String windDirection, String minTemperature, String minApparentTemperature) {
        super(time, temperature, rain, snowfall, apparentTemperature, windSpeed, windDirection);
        this.maxTemperature = temperature;
        this.minTemperature = minTemperature;
        this.maxApparentTemperature = apparentTemperature;
        this.minApparentTemperature = minApparentTemperature;
    }

    public void display()
    {
        System.out.println("Time:  " + time);
        System.out.println("Max temperature: " + maxTemperature);
        System.out.println("Min temperature: " + minTemperature);
        System.out.println("Max apparent temperature: " + maxApparentTemperature);
        System.out.println("Min apparent temperature: " + minApparentTemperature);
        System.out.println("Rain: " + rain);
        System.out.println("Snowfall: " + snowfall);
        System.out.println("Wind Speed: " + windSpeed);
        System.out.println("Wind Direction: " + windDirection);
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public String getMaxApparentTemperature() {
        return maxApparentTemperature;
    }

    public String getMinApparentTemperature() {
        return minApparentTemperature;
    }
}
