package com.svalero.museumexplorer.controller;

import com.svalero.museumexplorer.model.Record;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ObjectView implements Initializable {
    private Record record;
    @FXML
    public Text txtTitle;
    @FXML
    public Text txtClassfication;
    @FXML
    public Text txtPeriod;
    @FXML
    public Text txtDated;
    @FXML
    public Text txtProvenance;
    @FXML
    public Text txtDivision;
    @FXML
    public Text txtCreditLine;
    @FXML
    public ImageView image;

    public ObjectView(Record record){
        this.record = record;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(record.getTitle() != null){
            txtTitle.setText("TITLE: " + record.getTitle());
        } else {
            txtTitle.setText("TITLE: No title");
        }
        if(record.getClassification() != null){
            txtClassfication.setText("CLASSIFICATION: " + record.getClassification());
        } else {
            txtClassfication.setText("CLASSIFICATION: No classification");
        }

        if(record.getPeriod() != null){
            txtPeriod.setText("PERIOD: " + record.getPeriod());
        } else {
            txtPeriod.setText("PERIOD: No period");
        }

        if(record.getDated() != null){
            txtDated.setText("DATED: " + record.getDated());
        } else {
            txtDated.setText("DATED: No dated");
        }

        if(record.getProvenance() != null){
            txtProvenance.setText("PROVENANCE: " + record.getProvenance());
        } else {
            txtProvenance.setText("PROVENANCE: No provenance");
        }

        if(record.getDivision() != null){
            txtDivision.setText("DIVISION: " + record.getDivision());
        } else {
            txtDivision.setText("DIVISION: No division");
        }

        if(record.getCreditline() != null){
            txtCreditLine.setText("CREDITLINE: " + record.getCreditline());
        } else {
            txtCreditLine.setText("CREDITLINE: No CreditLine");
        }
        if(record.getImages() != null){
            try {
                image.setImage(getImage(record.getImages().get(0).getBaseimageurl()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private Image getImage(String url) throws IOException {
        URL imageUrl = new URL(url);
        InputStream inputStream = imageUrl.openStream();
        Image image = new Image(inputStream);
        return image;
    }
}
