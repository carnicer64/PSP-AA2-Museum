package com.svalero.museumexplorer;

import com.svalero.museumexplorer.controller.AppController;
import com.svalero.museumexplorer.util.R;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getUI("main.fxml"));
        loader.setController(new AppController());
        VBox vbox = loader.load();
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("MuseumExplorer");
        stage.show();
    }
}
