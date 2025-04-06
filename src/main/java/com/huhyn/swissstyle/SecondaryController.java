package com.huhyn.swissstyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class SecondaryController implements Initializable{
//new tornement page
    private Tornement curr;
    @FXML
    ComboBox<Integer> maxNum;
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void done() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        PrimaryController primary = loader.getController();
        switchToPrimary();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        maxNum.getItems().clear();
        maxNum.getItems().addAll(16,32,64);
        curr = new Tornement();
    }    
}