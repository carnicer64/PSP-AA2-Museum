package com.svalero.museumexplorer.controller;

import com.svalero.museumexplorer.model.buildings.Building;
import com.svalero.museumexplorer.model.buildings.Record;
import com.svalero.museumexplorer.task.LoadBuildingTask;
import com.svalero.museumexplorer.util.R;
import io.reactivex.functions.Consumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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

public class BuildingViewController implements Initializable {
    @FXML
    public ListView buildingsView;
    public ObservableList<Record> recordObservableList;
    public LoadBuildingTask loadBuildingTask;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recordObservableList = FXCollections.observableArrayList();

        buildingsView.setCellFactory(new Callback<ListView<Record>, ListCell<Record>>() {
            @Override
            public ListCell<Record> call(ListView<Record> buildingView) {
                return new ListCell<>(){
                    protected void updateItem(Record record, boolean empty){
                        super.updateItem(record, empty);
                        if(record != null && !empty){
                            Text name = new Text("Name: " + record.getName());
                            Text id = new Text("Identification Number: " + record.getId());
                            VBox vBox = new VBox(name, id);
                            setGraphic(vBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });

        String apikey = loadApiKey();
        Consumer<Building> buildingConsumer = (building) -> {
            for(Record record: building.getRecords()){
                recordObservableList.add(record);
                buildingsView.setItems(recordObservableList);
                buildingsView.refresh();
                Thread.sleep(200);
            }
        };

        loadBuildingTask = new LoadBuildingTask(buildingConsumer,10,1,apikey);
        new Thread(loadBuildingTask).start();


        buildingsView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    int index = buildingsView.getSelectionModel().getSelectedIndex();
                    Record record = recordObservableList.get(index);

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(R.getUI("buildingDetail.fxml"));
                    loader.setController(new BuildingDetailController(record));
                    VBox vBox;
                    try{
                        vBox = loader.load();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    Scene scene = new Scene(vBox);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Buildingw Details");
                    stage.show();
                }
            }
        });

    }

    public String loadApiKey() {
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
}
