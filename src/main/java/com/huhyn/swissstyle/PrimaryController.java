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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {
//tornement page --> home next page
    @FXML
    private void switchToHome() throws IOException {
        App.save();
        App.setRoot("Home");
    }
    @FXML ComboBox rounds;
    @FXML ListView<String> games;
    List<String> gameView;
    int currRound;
    @FXML 
    private void swap() throws IOException{
        if (games.getSelectionModel().getSelectedItems().size()!=2){
            
        }
        else{
            int i1= gameView.indexOf(games.getSelectionModel().getSelectedItems().get(0));
            int i2= gameView.indexOf(games.getSelectionModel().getSelectedItems().get(1));
            Person temp = App.getCurr().tornement.get(currRound).game.get(i1).one;
            App.getCurr().tornement.get(currRound).game.get(i1).one =App.getCurr().tornement.get(currRound).game.get(i2).one;
            App.getCurr().tornement.get(currRound).game.get(i2).one = temp;
        }
        showRound(currRound); 
    }
    @FXML
    private void addScore() throws IOException{
                if (games.getSelectionModel().getSelectedItems().size()!=1){
            
        }
                else{
                    App.editing=App.getCurr().tornement.get(currRound).game.get(gameView.indexOf(games.getSelectionModel().getSelectedItems().get(0)));
                    App.setRoot("Person");//wrong name but eh
                }
    }
    private void showRound(int r){
        gameView.clear();
        for (int i =0; i<App.getCurr().tornement.get(r).game.size(); i++){
            gameView.add(App.getCurr().tornement.get(r).game.get(i).one.name+
                        " vs. "+
                        App.getCurr().tornement.get(r).game.get(i).two.name +App.getCurr().tornement.get(currRound).game.get(i).score
                );
            }
        ObservableList<String> GameView = FXCollections.observableArrayList(gameView);
        games.setItems(GameView);
    }
    @FXML private void newRound(){
        for (int i = 0; i<App.getCurr().tornement.get(currRound).game.size();i++){
            App.getCurr().tornement.get(currRound).game.get(i).calculate();
        }
       App.getCurr().newRound();
       currRound++;
       showRound(currRound);
    }
    @FXML private void switchRounds(){
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                //rounds dropdown
        currRound = 0;
        games.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        gameView = new ArrayList<String>();
        if (App.getCurr().tornement.size()==0){
            //make inital round
            App.getCurr().initialROund();
        }
        showRound(0);
        rounds.getItems().clear();
        ArrayList<String> roundname = new ArrayList<String>();
        for (int i = 0; i<App.getCurr().tornement.size(); i++){
            String name = "Round"+(i+1);
            roundname.add(name);
        }
        ObservableList<String> options = FXCollections.observableArrayList(roundname);
        rounds.getItems().addAll(options);


    }
    
}
