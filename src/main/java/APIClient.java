import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIClient {
    private String baseUrl;

    public APIClient(String url) {
        this.baseUrl = url;
    }

    public String getWeatherData(double latitude, double longitude, String other) throws IOException {
        String fullUrl = this.baseUrl + "?latitude=" + latitude + "&longitude=" + longitude + "&" + other;

        URL url = new URL(fullUrl);
        System.out.println(url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if (con.getResponseCode() != 200) {
            throw new IOException("Error: " + con.getResponseMessage());
        }

        Scanner in = new Scanner(con.getInputStream());
        StringBuilder response = new StringBuilder();
        while (in.hasNext())
        {
            response.append(in.nextLine());
        }

        return response.toString();
    }
}
