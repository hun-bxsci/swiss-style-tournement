/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.huhyn.swissstyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;

/**
 * FXML Controller class
 *
 * @author nhyhu
 */
public class AddPeopleController implements Initializable {
    //variables
    @FXML ListView<String> List;
    @FXML TextField name;
    @FXML TextField club;
    @FXML TextField rating;
    @FXML Label warning;
    boolean first;
    List<String> names;
    ObservableList fin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        first = true;
        fin = FXCollections.observableArrayList();
        names = new ArrayList<String>();
    }    
    @FXML
    private void confirmButton()throws IOException{
        //check even number of people for pairing later
        if (App.getCurr().people.size()%2!=0){
            warning.setText("Only even number of players allowed.");
            warning.setVisible(true);
        }
        else if (first){
            //confirm pop up first then switch
            warning.setText("Click \"Done\" again to confirm all players are added. No players can be added after confirming.");
            warning.setVisible(true);
            first =!first;
        }
        else{
        App.setRoot("primary");
        }
    }
    @FXML
    private void addperson() throws IOException{
        //check at least name and rating is filled
        first =true;
        if (name.getText()==""||rating.getText()==""){
            warning.setText("Fill out required fields.");
            warning.setVisible(true);
        }
        else{
            Person temp = new Person(name.getText(),club.getText(),Integer.parseInt(rating.getText()));
            App.getCurr().people.add(temp);
            names.add(name.getText()+" - "+club.getText()+" - "+rating.getText());
            fin.clear();
            fin.addAll(names);
            List.setItems(fin);
        }
        
    }
    @FXML
    private void deletePerson() throws IOException{
        for (int i =0; i<names.size();i++){
            if (names.get(i) == List.getSelectionModel().getSelectedItem()){
                App.getCurr().people.remove(i);
                names.remove(i);
            }
        }
        
    }
    
    
}
