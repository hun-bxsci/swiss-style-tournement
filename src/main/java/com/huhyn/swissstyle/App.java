package com.huhyn.swissstyle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static ArrayList<Tornement> t;
    private static ArrayList<String> tornementView;
    @Override
    public void start(Stage stage) throws IOException {
        
        
        scene = new Scene(loadFXML("Home"), 640, 480);
        stage.setScene(scene);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void newTournement(){
        Tornement newT = new Tornement();
        t.add(newT);
    }
    
    public static void getTournement(){
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}