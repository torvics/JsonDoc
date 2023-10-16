package Ejercicio_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TableJson {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Sales Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un modelo de tabla
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable jTable = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Car");
        tableModel.addColumn("Price");
        tableModel.addColumn("State");

        try {
            // Leer el archivo JSON
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("car_sales.json"));

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String id = jsonObject.get("id").toString();
                String firstName = (String) jsonObject.get("first_name");
                String lastName = (String) jsonObject.get("last_name");
                String car = (String) jsonObject.get("car");
                String price = (String) jsonObject.get("price");
                String state = (String) jsonObject.get("state");
                tableModel.addRow(new String[]{id, firstName, lastName, car, price, state});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(jTable);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}