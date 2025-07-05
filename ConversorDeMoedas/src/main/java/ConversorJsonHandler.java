import com.google.gson.Gson;

import java.util.Map;

public class ConversorJsonHandler {
    public Map<String, Double> conversion_rates;

    ConversorJsonHandler(){}


    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

     public void jSonToMap(String json) {
        Gson gson = new Gson();
        this.conversion_rates = gson.fromJson(json, ConversorJsonHandler.class).getConversion_rates();
    }
}
