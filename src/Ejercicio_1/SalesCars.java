package Ejercicio_1;

import com.google.gson.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SalesCars {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("car_sales.json");
            JsonArray jsonArray = JsonParser.parseReader(fileReader).getAsJsonArray();

            Map<String, Double> Prices = new HashMap<>();
            Map<String, Integer> CarCount = new HashMap();


            for (JsonElement element : jsonArray) {
                if (element.isJsonObject()) {
                    JsonObject carObject = element.getAsJsonObject();

                    if (carObject.has("car") && carObject.has("price")) {

                        String car = carObject.get("car").getAsString();
                        String priceA = carObject.get("price").getAsString();
                        String priceB = priceA.substring(1);
                        double price = Double.parseDouble(priceB);

                        if (Prices.containsKey(car)) {
                            Double currentPriceSum = Prices.get(car);
                            Prices.put(car, currentPriceSum + price);
                        } else {
                            Prices.put(car, price);
                        }

                        if (CarCount.containsKey(car)) {
                            int currentCarCount = CarCount.get(car);
                            CarCount.put(car, currentCarCount + 1);
                        } else {
                            CarCount.put(car, 1);
                        }
                    }
                }
            }

            System.out.println("\nReporte de precios promedio por marca: \n");

            for (String marca : Prices.keySet()) {
                double priceSum = Prices.get(marca);
                int carCount = CarCount.get(marca);
                double averagePrice = priceSum / carCount;

                System.out.println("Marca: " + marca +
                        "\n" + "Promedio de Precio: " + averagePrice + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
