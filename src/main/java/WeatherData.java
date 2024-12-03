public class WeatherData {
    protected String temperature;
    protected String rain;
    protected String snowfall;
    protected String apparentTemperature;
    protected String windSpeed;
    protected String windDirection;
    protected String time;

    public WeatherData(String time, String temperature, String rain, String snowfall, String apparentTemperature, String windSpeed, String windDirection) {
        this.time = time;
        this.temperature = temperature;
        this.rain = rain;
        this.snowfall = snowfall;
        this.apparentTemperature = apparentTemperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getApparentTemperature() {
        return apparentTemperature;
    }

    public String getRain() {
        return rain;
    }

    public String getSnowfall() {
        return snowfall;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getTime() {
        return time;
    }
}
