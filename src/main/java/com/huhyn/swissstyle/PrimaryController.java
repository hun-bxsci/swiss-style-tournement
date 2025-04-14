package com.huhyn.swissstyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {
//tornement page --> home next page
    private Tornement curr;
    @FXML
    private void switchToSecondary() throws IOException {
        //make new tournement before switching

        App.setRoot("secondary");
    }
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("Home");
    }
    @FXML ComboBox rounds;
    @FXML VBox games;
    @FXML 
    private void swap() throws IOException{
        
    }
    public void passer(Tornement t, int i){
        curr=t;
        System.out.println(i);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                //rounds dropdown
        rounds.getItems().clear();
        ArrayList<String> roundname = new ArrayList<String>();
        for (int i = 0; i<curr.tornement.size(); i++){
            String name = "Round"+i;
            roundname.add(name);
        }
        ObservableList<String> options = FXCollections.observableArrayList(roundname);
        rounds.getItems().addAll(options);
        
        if (curr.tornement.size()>0){
            //show 1st round
        }
    }
    
}
