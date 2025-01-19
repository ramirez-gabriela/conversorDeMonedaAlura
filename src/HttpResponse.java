import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpResponse {
    public static String getResponse(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }
}

