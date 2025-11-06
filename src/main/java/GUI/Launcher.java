package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    //Codigo que actua como el sistema que da inicio al codigo mediante el inicio de la escena menu
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI_WeatherData/interfaz_data.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setFullScreen(false);
        stage.setTitle("DataSet - Bienvenida");
        stage.setScene(scene);
        stage.show();
        stage.resizableProperty().setValue(Boolean.FALSE);


    }



    //MAIN
    public static void main(String[] args) {
        launch(args);
    }
}
