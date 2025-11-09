import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherService {

    // Ganti dengan API key kamu dari https://openweathermap.org/api
    private final String apiKey = "YOUR_API_KEY";

    public JSONObject getWeather(String city) throws IOException {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city
                + "&appid=" + apiKey + "&units=metric&lang=id";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        return new JSONObject(result.toString());
    }
}