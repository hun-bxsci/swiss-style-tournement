package com.huhyn.swissstyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //load tournements.json onto vbox
        selected = 0;
    }
    private int selected;
    @FXML ListView<String> List;
    @FXML Text wrongNumber;
    @FXML
    private void switchToSecondary() throws IOException {
        //new tournement page
        App.setRoot("secondary");
    }
    @FXML
    private void existingTournemnt() throws IOException{
        if (selected != 1){
            wrongNumber = new Text("No tournement selected or more than one tournment selected");
        }
        else{
            //get the selected tournement and set it to app.curr
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
