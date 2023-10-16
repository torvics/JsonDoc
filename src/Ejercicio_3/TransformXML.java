package Ejercicio_3;

import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class TransformXML {
    public static void main(String[] args) {

        try {
            BufferedReader Leerxml = new BufferedReader(new FileReader("car_sales.xml"));
            StringBuilder Contenido = new StringBuilder();
            String line;

            while ((line = Leerxml.readLine()) != null) {
                Contenido.append(line);
            }

            Leerxml.close();
            JSONObject json = XML.toJSONObject(Contenido.toString());
            FileWriter GuardarJson = new FileWriter("car_sales2.json");
            GuardarJson.write(json.toString(4));
            GuardarJson.close();

            System.out.println("Archivo Json guardado como : car_sales2.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

