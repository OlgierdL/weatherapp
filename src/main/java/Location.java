public class Location {
    public String city;
    public String country;
    public double lat;
    public double lng;

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
        LocationAPI locationAPI = new LocationAPI();
        double[] coordinates = locationAPI.getCoordinates(city, country);
        this.lat = coordinates[0];
        this.lng = coordinates[1];
    }

    public double getLat() {
        return lat;
    }
    public double getLng() {
        return lng;
    }
}
