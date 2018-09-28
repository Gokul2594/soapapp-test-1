package Controllers;

import Models.Soap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SoapDetailsViewController implements Initializable {

    //Instantiating fxml scene objects
    @FXML private Label brandLabel;
    @FXML private Label intendedUseLabel;
    @FXML private Label volumeLabel;
    @FXML private ChoiceBox<Soap> soapChoiceBox;
    @FXML private ImageView soapImage = new ImageView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Soap> soapObjects = new ArrayList<>();
        soapObjects.addAll(createSoapObjects());
        soapChoiceBox.getItems().addAll(soapObjects); // Adding values to choice box
        soapChoiceBox.setValue(soapObjects.get(0));

        updateView(soapObjects.get(0));
        soapChoiceBox.getSelectionModel().selectedItemProperty().addListener( // update view on change of choice box
                //this is our custom listener
                (observable, oldValue, newValue) ->{
                    updateView(newValue);
                }
        );
    }

    /**
     * Method to create default soap objects
     * @return
     */
    public ArrayList<Soap> createSoapObjects(){
        ArrayList<Soap> soapObjects = new ArrayList<>();
        soapObjects.add(new Soap("Palmolive", "Dish", 887));
        soapObjects.add(new Soap("Dawn", "Hand", 8000));
        soapObjects.add(new Soap("Lemon", "Floor", 370));
        soapObjects.add(new Soap("Meyers", "Dish", 236));
        soapObjects.add(new Soap("Murphys", "Floor", 473));
        return soapObjects;
    }

    /**
     * Method to update view when choice box is updated
     * @param soap
     */
    public void updateView(Soap soap){
        this.brandLabel.setText(soap.getBrand());
        this.intendedUseLabel.setText(soap.getIntendedUse());
        this.volumeLabel.setText(String.format("%s", soap.getVolume()));
        this.soapImage.setImage(soap.getSoapImage());
    }
}
