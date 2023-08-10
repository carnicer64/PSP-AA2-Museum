package com.svalero.museumexplorer.controller;

import com.svalero.museumexplorer.model.buildings.Record;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class BuildingDetailController implements Initializable {

    private Record record;
    @FXML
    public Text txtName;
    @FXML
    public Text txtAddress;
    @FXML
    public Text txtId;
    @FXML
    public Text txtUpdate;
    @FXML
    public ImageView imageGPS;

    public BuildingDetailController(Record record) {
        this.record = record;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(record.getName() != null){
            txtName.setText("NAME: " + record.getName());
        } else {
            txtName.setText("NAME: No name");
        }
        if(record.getAddress() != null){
            txtAddress.setText("ADDRESS: " + record.getAddress());
        } else {
            txtAddress.setText("ADDRESS: No Address");
        }
        if(record.getId() != null){
            txtId.setText("IDENTIFICATION NUMBER: " + record.getId());
        } else {
            txtId.setText("IDENTIFICATION NUMBER: No ID");
        }
        if(record.getLastupdate() != null){
            txtUpdate.setText("LAST UPDATE: " + record.getLastupdate());
        } else {
            txtUpdate.setText("LAST UPDATE: No update");
        }
        if(record.getGeo() != null){
            try {
                imageGPS.setImage(getImage(record.getGeo().getLon(),record.getGeo().getLat()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private Image getImage(Double longitude, Double latitude) throws IOException {
        //https://api.mapbox.com/styles/v1/mapbox/streets-v12/static/-122.4241,37.78,15.25,0,0/400x400?access_token=pk.eyJ1IjoiY2FybmljZXI2NCIsImEiOiJjbGw1YXcxd3MwZzlhM2ZvMWZvdTNhenByIn0.tI8VekhNW-x79aoIMV7nyA
        String url = "https://api.mapbox.com/styles/v1/mapbox/streets-v12/static/" + longitude + "," + latitude + ",15.25,0,0/400x400?access_token=pk.eyJ1IjoiY2FybmljZXI2NCIsImEiOiJjbGw1YXcxd3MwZzlhM2ZvMWZvdTNhenByIn0.tI8VekhNW-x79aoIMV7nyA";
        URL imageUrl = new URL(url);
        InputStream inputStream = imageUrl.openStream();
        Image image = new Image(inputStream);
        return image;
    }
}
