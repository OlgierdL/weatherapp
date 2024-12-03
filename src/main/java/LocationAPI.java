import com.opencagedata.jopencage.JOpenCageGeocoder;
import com.opencagedata.jopencage.model.JOpenCageForwardRequest;
import com.opencagedata.jopencage.model.JOpenCageResponse;
import com.opencagedata.jopencage.model.JOpenCageLatLng;

public class LocationAPI {

    public LocationAPI() {}

    public double[] getCoordinates(String city, String country){
        String query = city + ", " + country;
        String apiKey = "55713c6864504a41a8dcf688358eb908";
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(apiKey);
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(query);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition();
        System.out.println(firstResultLatLng.getLat().toString() + "," + firstResultLatLng.getLng().toString());
        return new double[]{firstResultLatLng.getLat(), firstResultLatLng.getLng()};
    }
}
