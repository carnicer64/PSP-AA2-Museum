package com.svalero.museumexplorer.controller;

import com.svalero.museumexplorer.model.Data;
import com.svalero.museumexplorer.model.Record;
import com.svalero.museumexplorer.task.ExportDataTask;
import com.svalero.museumexplorer.task.LoadDataTask;
import com.svalero.museumexplorer.task.LoadRecordsTask;
import com.svalero.museumexplorer.util.R;
import io.reactivex.functions.Consumer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

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
    public Button btExport;
    @FXML
    public Text txtPage;
    @FXML
    public Text txtRecords;
    @FXML
    public ProgressBar pbLoad;
    @FXML
    public ListView<Record> objectList;
    public ObservableList<Record> recordObservableList;
    public ObservableList<Record> fullRecordObservableList;
    public LoadDataTask loadDataTask;
    public LoadRecordsTask loadRecordTask;
    public ExportDataTask exportDataTask;
    public Data data;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recordObservableList   = FXCollections.observableArrayList();
        fullRecordObservableList = FXCollections.observableArrayList();

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
            this.data = data;
        };

        loadDataTask = new LoadDataTask(10, 1, apikey, dataConsumer);
        new Thread(loadDataTask).start();

        Consumer<Record> recordConsumer = (record) -> {
                recordObservableList.add(record);
                fullRecordObservableList.add(record);
                objectList.setItems(recordObservableList);
                objectList.refresh();
                Thread.sleep(200);
                double progress = pbLoad.getProgress();
                pbLoad.setProgress(progress + 0.1);
        };

        loadRecordTask = new LoadRecordsTask(10, 1, apikey, recordConsumer);
        new Thread(loadRecordTask).start();

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

        // Busqueda o filtrado de datos

        txtField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String anterior, String nuevo) {
                if(nuevo.length() != 0){
                    Predicate<Record> filter = record -> record.getTitle().contains(nuevo);
                    recordObservableList = fullRecordObservableList;
                    recordObservableList = recordObservableList.filtered(filter);
                } else {
                    recordObservableList = fullRecordObservableList;
                }
                objectList.setItems(recordObservableList);
                objectList.refresh();
            }
        });

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

    //Salia ERROR: No es un hilo de JavaFX y aunque se ejecutaba saltaba el error. En vez del completableFuture.get he usado exceptionally

    @FXML
    public void exportData(ActionEvent actionEvent) throws InterruptedException {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(objectList.getScene().getWindow());

        if(file != null){
            exportDataTask = new ExportDataTask(recordObservableList, file);

        }

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            exportDataTask.run();
            return exportDataTask.getValue();
        });

        completableFuture.exceptionally(result -> {
            Platform.runLater(() -> {
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Data exported");
                alert.setHeaderText("Records exported succesfully");
                alert.setContentText("Check destination folder");
                alert.showAndWait();
            });
            return null;
        });
    }
}
