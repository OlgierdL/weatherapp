public class CurrentData extends WeatherData{
    private final String humidity;
    private final String pressure;
    private final String isDay;
    private final String cloudCover;

    public CurrentData(String time, String temperature, String rain, String snowfall, String apparentTemperature, String windSpeed, String windDirection, String humidity, String isDay, String cloudCover, String surfacePressure) {
        super(time, temperature, rain, snowfall, apparentTemperature, windSpeed, windDirection);
        this.humidity = humidity;
        this.isDay = isDay;
        this.cloudCover = cloudCover;
        this.pressure = surfacePressure;
    }

    public void display() {
        System.out.println("Time: " + time);
        System.out.println("Temperature: " + temperature);
        System.out.println("Humidity: " + humidity);
        System.out.println("Pressure: " + pressure);
        System.out.println("Is Day: " + isDay);
        System.out.println("Cloud Cover: " + cloudCover);
        System.out.println("Rain: " + rain);
        System.out.println("Snowfall: " + snowfall);
        System.out.println("Apparent Temperature: " + apparentTemperature);
        System.out.println("Wind Speed: " + windSpeed);
        System.out.println("Wind Direction: " + windDirection);
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public String getIsDay() {
        return isDay;
    }

    public String getCloudCover() {
        return cloudCover;
    }
}
