package com.huhyn.swissstyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nhyhu
 */
public class HomeController implements Initializable {  
        private int selected;
    @FXML ListView<String> List;
    @FXML Text wrongNumber;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //load tournements.json onto vbox
        selected = 0;
        ObservableList fin = FXCollections.observableArrayList();
        List<String> l= new ArrayList<String>();
        for (int i = 0; i<App.tornementView.size(); i++){
            l.add(App.tornementView.get(i));
        }
        fin.addAll(l);
        List.setItems(fin);
    }
    
    @FXML
    private void existingTournemnt() throws IOException{
        if (List.getSelectionModel().getSelectedItem()== null){
            wrongNumber.setText("No tournement selected");
        }
        else{
            //get the selected tournement and set it to app.curr
            App.loadTournement(List.getSelectionModel().getSelectedItem());
            App.setRoot("primary");
        }
    }
    @FXML
    private void newGame() throws IOException{
        App.newTournement();
        App.setRoot("secondary");
    }
    private void wrongNumberOfSelection(){
        wrongNumber = new Text("No tournement selected or more than one tournment selected");
    }
}
