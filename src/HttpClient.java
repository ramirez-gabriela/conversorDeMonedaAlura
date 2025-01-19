import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public static HttpURLConnection createRequest(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        return connection;
    }
}
