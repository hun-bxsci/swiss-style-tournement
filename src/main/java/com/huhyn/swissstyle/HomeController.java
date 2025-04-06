package com.huhyn.swissstyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author nhyhu
 */
public class HomeController implements Initializable {  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //load tournements.json onto vbox
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void newGame() throws IOException{
        App.newTournement();
        App.setRoot("secondary");
    }
}
