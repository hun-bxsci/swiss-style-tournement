/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.huhyn.swissstyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nhyhu
 */
public class PersonController implements Initializable {
    @FXML Text players;
    @FXML Text currScore;
    @FXML TextField input;
    @FXML Button done;
    /**
     * Initializes the controller class.
     */
    @FXML 
    private void done()throws IOException{
        App.editing.score = App.editing.score+ input.getText();
        App.setRoot("primary");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currScore.setText(App.editing.score);
        players.setText(App.editing.one.name+" vs. "+ App.editing.two.name);
    }    
    
}
