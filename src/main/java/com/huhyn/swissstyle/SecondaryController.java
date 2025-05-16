package com.huhyn.swissstyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SecondaryController implements Initializable{
//new tournement page
    @FXML
    TextField name;
    @FXML
    TextArea des;
    @FXML
    Label incomplete;
    @FXML
    private void done() throws IOException{
        if (name.getText().isEmpty()){
            incomplete.setVisible(true);
        }
        else{
        //set in run time memory
        App.setCurrName(name.getText());//temp
        App.addTournement(name.getText());
        App.setRoot("addPeople");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        App.newTournement();
    }    
}