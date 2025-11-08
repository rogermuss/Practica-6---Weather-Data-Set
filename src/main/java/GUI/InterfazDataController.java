package GUI;

import DataSet.Data;
import DataSet.Ordenamientos;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InterfazDataController {

    Data data = new Data();
    Ordenamientos ordenamientos;

    @FXML TitledPane titledPane0;
    @FXML TitledPane titledPane1;
    @FXML TitledPane titledPane2;
    @FXML TitledPane titledPane3;
    @FXML TitledPane titledPane4;
    @FXML TitledPane titledPane5;
    @FXML TitledPane titledPane6;
    @FXML TitledPane titledPane7;
    @FXML TitledPane titledPane8;
    @FXML TitledPane titledPane9;
    @FXML TitledPane titledPane10;
    @FXML TitledPane titledPane11;

    @FXML BarChart<Object,Object> grafica0;
    @FXML BarChart<Object,Object> grafica1;
    @FXML BarChart<Object,Object> grafica2;
    @FXML BarChart<Object,Object> grafica3;
    @FXML BarChart<Object,Object> grafica4;
    @FXML BarChart<Object,Object> grafica5;
    @FXML BarChart<Object,Object> grafica6;
    @FXML BarChart<Object,Object> grafica7;
    @FXML BarChart<Object,Object> grafica8;
    @FXML BarChart<Object,Object> grafica9;
    @FXML BarChart<Object,Object> grafica10;
    @FXML BarChart<Object,Object> grafica11;

    @FXML ListView<String> listView0;
    @FXML ListView<String> listView1;
    @FXML ListView<String> listView2;
    @FXML ListView<String> listView3;
    @FXML ListView<String> listView4;
    @FXML ListView<String> listView5;
    @FXML ListView<String> listView6;
    @FXML ListView<String> listView7;
    @FXML ListView<String> listView8;
    @FXML ListView<String> listView9;
    @FXML ListView<String> listView10;
    @FXML ListView<String> listView11;


    @FXML Label paneLabel0;
    @FXML Label paneLabel1;
    @FXML Label paneLabel2;
    @FXML Label paneLabel3;
    @FXML Label paneLabel4;
    @FXML Label paneLabel5;
    @FXML Label paneLabel6;
    @FXML Label paneLabel7;
    @FXML Label paneLabel8;
    @FXML Label paneLabel9;
    @FXML Label paneLabel10;
    @FXML Label paneLabel11;

    @FXML Button exitButton;
    @FXML Button resetButton;

    private BarChart<String, Number>[] graficas;
    private ArrayList<ListView<String>> listViews;
    private ArrayList<Label> headerLabels;
    private ArrayList<TitledPane> titledPanes;



    public BarChart<String, Number>[] getGraficas() { return new BarChart[]{
            grafica0, grafica1, grafica2,
            grafica3, grafica4, grafica5,
            grafica6, grafica7, grafica8,
            grafica9, grafica10, grafica11 }; }

    public void inicializarArreglos() {

        // Inicializar listas

        listViews = new ArrayList<>();
        headerLabels = new ArrayList<>();
        titledPanes = new ArrayList<>();

        // Cargar ListViews
        listViews.addAll(Arrays.asList(
                listView0, listView1, listView2, listView3,
                listView4, listView5, listView6, listView7,
                listView8, listView9, listView10, listView11
        ));

        // Cargar Labels del header
        headerLabels.addAll(Arrays.asList(
                paneLabel0, paneLabel1, paneLabel2, paneLabel3,
                paneLabel4, paneLabel5, paneLabel6, paneLabel7,
                paneLabel8, paneLabel9, paneLabel10, paneLabel11
        ));

        titledPanes.addAll(Arrays.asList(
                titledPane0, titledPane1, titledPane2,
                titledPane3, titledPane4, titledPane5,
                titledPane6, titledPane7, titledPane8,
                titledPane9, titledPane10, titledPane11
        ));

        for (TitledPane pane : titledPanes) {
            pane.setMinWidth(600);   // Ajusta según lo que necesites
            pane.setPrefWidth(Region.USE_COMPUTED_SIZE);
            pane.setMaxWidth(Double.MAX_VALUE); // Permite que se expanda
        }


    }



    @FXML private void initialize() throws IOException {
        //Inicializo los elementos graficos
        inicializarArreglos();
        graficas = getGraficas();

        for (BarChart<String, Number> grafica : graficas) {

            grafica.setPrefHeight(250);
            grafica.setPadding(new Insets(10, 10, 40, 10));


        }

        for (int i = 0; i < headerLabels.size(); i++) {
            configurarAccionHeader(headerLabels.get(i), titledPanes.get(i));
        }

        fillLists();

        exitButton();
    }


    public void fillLists() {

        for (int i = 0; i < titledPanes.size(); i++) {

            String[] arregloCopiado = copiarArreglo(i);

            ListView<String> listView = listViews.get(i);

            listView.getItems().clear();
            listView.getItems().addAll(Arrays.asList(arregloCopiado));
        }
    }


    public void configurarAccionHeader(Label label, TitledPane pane) {


        pane.setCollapsible(false);


        label.setOnMouseClicked(event -> mostrarAlertaOrdenamiento(pane));
    }

    public void mostrarAlertaOrdenamiento(TitledPane pane) {

        Dialog<List<String>> dialog = new Dialog<>();
        dialog.setTitle("Seleccion de metodos de Ordenamiento :)");
        dialog.setHeaderText("Elija los metodos que desee ejecutar:");

        // Botones
        ButtonType btnAceptar = new ButtonType("Ejecutar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnAceptar, ButtonType.CANCEL);

        // Checkboxes
        CheckBox chkQuick = new CheckBox("QuickSort");
        CheckBox chkMerge = new CheckBox("MergeSort");
        CheckBox chkShell = new CheckBox("ShellSort");
        CheckBox chkSeleccion = new CheckBox("Selection Sort");
        CheckBox chkRadix = new CheckBox("RadixSort");
        CheckBox chkSort = new CheckBox("Arrays.sort()");
        CheckBox chkParallel = new CheckBox("Arrays.parallelSort()");

        VBox content = new VBox();
        content.getChildren().addAll(
                chkQuick, chkMerge, chkShell,
                chkSeleccion, chkRadix, chkSort, chkParallel
        );
        dialog.getDialogPane().setContent(content);

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/CSSs/alert.css").toExternalForm()
        );

        dialog.setResultConverter(button -> {
            if(btnAceptar == button) {
                List<String> seleccionados = new ArrayList<>();

                if (chkQuick.isSelected()) seleccionados.add("QuickSort");
                if (chkMerge.isSelected()) seleccionados.add("MergeSort");
                if (chkShell.isSelected()) seleccionados.add("ShellSort");
                if (chkSeleccion.isSelected()) seleccionados.add("Selection");
                if (chkRadix.isSelected()) seleccionados.add("RadixSort");
                if (chkSort.isSelected()) seleccionados.add("sort()");
                if (chkParallel.isSelected()) seleccionados.add("parallelSort()");

                return seleccionados;
            }

            return null;
        });
        Optional<List<String>> result = dialog.showAndWait();

        if (result.isPresent() && !result.isEmpty()) {
            probarRendimiento(obtenerArregloParaPane(pane), pane, result.get());
        }
    }

    public String[] obtenerArregloParaPane(TitledPane pane) {

        int index = Integer.parseInt(pane.getId().replace("titledPane", ""));


        return copiarArreglo(index);
    }



    public void exitButton() throws IOException {
        exitButton.setOnMouseClicked(event -> {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Salir");
            alerta.setHeaderText("¿Estás seguro de que quieres salir?");
            alerta.setContentText("Se cerrará la aplicación.");

            DialogPane dialogPane = alerta.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/CSSs/alert.css").toExternalForm()
            );

            if (alerta.showAndWait().get() == ButtonType.OK) {
                System.exit(0);
            }
        });

    }

    public String[] copiarArreglo(int indiceFijo){
        String[] arreglo = new String[data.getColumnas().length-1];

        for(int i = 1; i < data.getColumnas().length; i++){
            arreglo[i-1] = data.getColumnas()[i][indiceFijo];
        }
        return arreglo;
    }

    public boolean isDouble(String cadena){
        if (cadena == null) return false;
        try {
            Double.parseDouble(cadena);  // si no es válido lanza excepción
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void probarRendimiento(String[] arregloOriginal, TitledPane titledPane, List<String> metodos) {

        String[] arreglo = arregloOriginal.clone();
        double[] resultado =  new double[arreglo.length];

        if (isDouble(arreglo[0])) {
            for (int i = 0; i < arreglo.length; i++) {
                resultado[i] = Double.parseDouble(arreglo[i]);
            }

        }


        VBox vbox = (VBox) titledPane.getContent();

        ListView<String> listView = null;
        BarChart<String, Number> barChart = null;

        for (Node node : vbox.getChildren()) {
            if (node instanceof ListView)
                listView = (ListView<String>) node;

            if (node instanceof BarChart)
                barChart = (BarChart<String, Number>) node;
        }

        if (listView == null || barChart == null) {
            return;
        }

        long tQuick = 0, tMerge = 0, tShell = 0, tSel = 0, tRadix = 0, tSort = 0, tPar = 0;
        for(String elemento: metodos) {
            if (!isDouble(arreglo[0])) {
                switch (elemento) {
                    case "QuickSort":
                    tQuick = medirTiempo(() -> Ordenamientos.quickSort(arreglo.clone()));
                    break;
                    case "MergeSort":
                    tMerge = medirTiempo(() -> Ordenamientos.mergeSort(arreglo.clone()));
                    break;
                    case "ShellSort":
                    tShell = medirTiempo(() -> Ordenamientos.shell(arreglo.clone(), arreglo.length));
                    break;
                    case "Selection":
                    tSel = medirTiempo(() -> Ordenamientos.selection(arreglo.clone(), arreglo.length));
                    break;
                    case "RadixSort":
                    tRadix = medirTiempo(() -> Ordenamientos.radixSortStrings(arreglo.clone()));
                    break;
                    case "sort()":
                    tSort = medirTiempo(() -> Arrays.sort(arreglo.clone()));
                    break;
                    case "parallelSort()":
                    tPar = medirTiempo(() -> Arrays.parallelSort(arreglo.clone()));
                    break;
                }
            } else {
                final double[] res = resultado;
                switch (elemento) {
                    case "QuickSort":
                        tQuick = medirTiempo(() -> Ordenamientos.quickSort(res.clone()));
                        break;
                    case "MergeSort":
                        tMerge = medirTiempo(() -> Ordenamientos.mergeSort(res.clone()));
                        break;
                    case "ShellSort":
                        tShell = medirTiempo(() -> Ordenamientos.shell(res.clone(), res.length));
                        break;
                    case "Selection":
                        tSel = medirTiempo(() -> Ordenamientos.selection(res.clone(), res.length));
                        break;
                    case "RadixSort":
                        tRadix = medirTiempo(() -> Ordenamientos.radixSortStrings(arreglo.clone()));
                        break;
                    case "sort()":
                        tSort = medirTiempo(() -> Arrays.sort(res.clone()));
                        break;
                    case "parallelSort()":
                        tPar = medirTiempo(() -> Arrays.parallelSort(res.clone()));
                        break;
                }
            }
        }
        Series<String, Number> series = new Series<>();
        series.setName("Tiempo (ns)");

        series.getData().add(new XYChart.Data<>("QuickSort", tQuick));
        series.getData().add(new XYChart.Data<>("MergeSort", tMerge));
        series.getData().add(new XYChart.Data<>("ShellSort", tShell));
        series.getData().add(new XYChart.Data<>("Seleccion", tSel));
        series.getData().add(new XYChart.Data<>("RadixSort", tRadix));
        series.getData().add(new XYChart.Data<>("sort()", tSort));
        series.getData().add(new XYChart.Data<>("parallelSort()", tPar));

        CategoryAxis xAxis = (CategoryAxis) barChart.getXAxis();
        xAxis.setTickLabelsVisible(false);
        xAxis.setTickMarkVisible(false);

        NumberAxis yAxis = (NumberAxis) barChart.getYAxis();
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(50_000_000);
        yAxis.setTickUnit(5_000_000);
        yAxis.setLabel("Tiempo (nanosegundos)");

        barChart.getData().clear();
        barChart.getData().add(series);
        barChart.setLegendVisible(false);

        final String color1 = "#FF6B6B";
        final String color2 = "#4ECDC4";
        final String color3 = "#45B7D1";
        final String color4 = "#FFA07A";
        final String color5 = "#98D8C8";
        final String color6 = "#F7DC6F";
        final String color7 = "#BB8FCE";

        Platform.runLater(new Runnable() {
            public void run() {
                int index = 0;
                for (XYChart.Data<String, Number> dato : series.getData()) {
                    Node nodo = dato.getNode();

                    String color = "";
                    if (index == 0) color = color1;
                    else if (index == 1) color = color2;
                    else if (index == 2) color = color3;
                    else if (index == 3) color = color4;
                    else if (index == 4) color = color5;
                    else if (index == 5) color = color6;
                    else if (index == 6) color = color7;

                    nodo.setStyle("-fx-bar-fill: " + color + ";");

                    String nombreMetodo = dato.getXValue();
                    long nanosegundos = dato.getYValue().longValue();
                    String tiempoNs = String.format("%,d", nanosegundos);

                    Tooltip tooltip = new Tooltip(nombreMetodo + "\n" + tiempoNs + " ns");
                    tooltip.setStyle("-fx-font-size: 14px;");
                    Tooltip.install(nodo, tooltip);

                    index++;
                }
            }
        });

        if(!isDouble(arreglo[0])) {
            Arrays.sort(arreglo);
            listView.getItems().clear();
            listView.getItems().addAll(arreglo);
        }else{
            Arrays.sort(resultado);
            String[] res =  new String[resultado.length];
            for(int i = 0; i < listView.getItems().size(); i++){
                res[i] = Double.toString(resultado[i]);
            }
            listView.getItems().clear();
            listView.getItems().addAll(res);
        }

    }





    public long medirTiempo(Runnable metodo) {
        long inicio = System.nanoTime();
        metodo.run();
        long fin = System.nanoTime();

        return fin - inicio;
    }


}
