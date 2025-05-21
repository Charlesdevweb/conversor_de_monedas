import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.reflect.TypeToken;

public class MyApi {
    public static Map<String, Double> obtenerTasas() throws Exception {

        String clave = "1e8f6c187f6ced4e80ab77e7";
        String direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/USD";
        // Se crea el cliente  en HTTP (cliente), que va a pedir datos
        HttpClient client = HttpClient.newHttpClient();
        // Informamos la URL de la API y crea el build
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        // Envia solicitud y recibo la respuesta
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson();

        // Parsear el JSON completo
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // Obtener solo el arreglo "conversion_rates"
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        // Convertir el JSON a Map

        Map<String, Double> tasas = gson.fromJson(rates, Map.class);

        return gson.fromJson(rates, new TypeToken<Map<String, Double>>(){}.getType());

    }
}
/*
     Map<String, Double> tasas;

    public  MyApi (Map<String, Double> tasasInfo) throws IOException, InterruptedException {








        Map<String, Object> tasas = new HashMap<>();


        for (String key : rates.keySet()) {
            tasas.put(key, rates.get(key));
        }
      ///  return tasas;

        this.tasas =tasasInfo;


    }
    public void mostrar() { System.out.println(tasas); }

}

 */
