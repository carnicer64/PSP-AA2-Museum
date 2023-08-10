package com.svalero.museumexplorer.controller;


import com.svalero.museumexplorer.model.Data;
import com.svalero.museumexplorer.model.Record;
import com.svalero.museumexplorer.task.LoadDataTask;
import com.svalero.museumexplorer.util.R;
import io.reactivex.functions.Consumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    public TextField txtField;
    @FXML
    public Button btBack;
    @FXML
    public Button btNext;
    @FXML
    public Button btSearch;
    @FXML
    public Button btBuildings;
    @FXML
    public Text txtPage;
    @FXML
    public Text txtRecords;
    @FXML
    public ProgressBar pbLoad;
    @FXML
    public ListView objectList;
    public ObservableList<Record> recordObservableList;
    public LoadDataTask loadDataTask;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recordObservableList   = FXCollections.observableArrayList();

        objectList.setCellFactory(new Callback<ListView<Record>, ListCell<Record>>() {
            @Override
            public ListCell<Record> call(ListView<Record> recordListView) {
                return new ListCell<>(){
                  protected void updateItem(Record record, boolean empty){
                      super.updateItem(record, empty);
                      if(record != null && !empty){
                          Text title = new Text("Titulo: " + record.getTitle());
                          Text type = new Text("Clasificacion: " + record.getClassification());
                          VBox vBox = new VBox(title, type);
                          setGraphic(vBox);
                      } else {
                          setGraphic(null);
                      }
                  }
                };
            }
        });

        String apikey = loadApiKey();
        Consumer<Data> dataConsumer = (data) -> {
            for(Record record: data.getRecords()){
                recordObservableList.add(record);
                objectList.setItems(recordObservableList);
                objectList.refresh();
                Thread.sleep(200);
            }
        };

        loadDataTask = new LoadDataTask(10, 1, apikey, dataConsumer);
        new Thread(loadDataTask).start();

        objectList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount() == 2){
                    int index = objectList.getSelectionModel().getSelectedIndex();
                    Record record = recordObservableList.get(index);

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(R.getUI("objectView.fxml"));
                    loader.setController(new ObjectView(record));
                    VBox vBox;
                    try{
                        vBox = loader.load();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    Scene scene = new Scene(vBox);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Object Details");
                    stage.show();
                }
            }
        });


        //https://api.harvardartmuseums.org/object?size=5&page=1&apikey=59d0cdd5-36e6-4805-a86a-e0a6a3e791a0
    }

    public String loadApiKey(){
        Properties props = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                props.load(inputStream);
            } else {
                throw new FileNotFoundException("'config.properties' no encontrado");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer 'config.properties'", e);
        }
        String apiKey = props.getProperty("api.key");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new RuntimeException("No se pudo encontrar api.key en el archivo config.properties");
        }
        return apiKey;
    }

    @FXML
    public void loadBuildings(ActionEvent actionEvent) throws InterruptedException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getUI("buildingsView.fxml"));
        loader.setController(new BuildingViewController());
        VBox vBox;
        try{
            vBox = loader.load();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(vBox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Building List");
        stage.show();
    }
}
