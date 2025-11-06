package DataSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {

    String[][] columnas = new String[13][];

    public void leerCSV(){
        ArrayList<String[]> temp = new ArrayList<>();
        String ruta = "src/main/resources/WeatherDataSet/weatherHistory.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                temp.add(linea.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(temp.size());
        columnas = temp.toArray(new String[0][0]);



    }

    public String[][] getColumnas() {
        return columnas;
    }


    public static void main (String[] args) {
        Data datos = new Data();
        datos.leerCSV();
        String[][] columnas = datos.getColumnas();


    }


}
