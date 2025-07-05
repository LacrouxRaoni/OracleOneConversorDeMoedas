import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExternalApiRequestor {

    private String strUrl;

    public ExternalApiRequestor() {
    }

    public String callExternalApi(Requestor requestor) {
        strUrl = "https://v6.exchangerate-api.com/v6/aeff12ec7685cd1300703ed5/latest/" + requestor.getCurrency();
        try {
            URL url = new URL(strUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            return jsonobj.toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
