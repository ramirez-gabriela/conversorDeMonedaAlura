import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.HttpURLConnection;

public class CurrencyConversion {
    // API de ExchangeRate-API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/yourAPI/latest/";

    public static double convert(String sourceCurrency, String targetCurrency, double amount) {
        try {
            // Crear la URL completa
            String endpoint = API_URL + sourceCurrency;

            // Realizar la solicitud HTTP
            HttpURLConnection connection = HttpClient.createRequest(endpoint);
            String jsonResponse = HttpResponse.getResponse(connection);

            // Procesar la respuesta JSON
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

            if (!jsonObject.get("result").getAsString().equals("success")) {
                System.out.println("Error al obtener las tasas de cambio.");
                return 0.0;
            }

            // Extraer las tasas de cambio
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            if (!rates.has(targetCurrency)) {
                System.out.println("Moneda de destino no disponible.");
                return 0.0;
            }

            // Obtener la tasa y calcular el valor convertido
            double exchangeRate = rates.get(targetCurrency).getAsDouble();
            return amount * exchangeRate;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        }
    }
}
