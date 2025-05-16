package com.huhyn.swissstyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static List<Tornement> t;
    public static ArrayList<String> tornementView;
    public static Tornement curr;
    public static Game editing;
    @Override
    public void start(Stage stage) throws IOException {
        tornementView = new ArrayList<String>();
        t = new ArrayList<Tornement>();
        loadTView();
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
    
    private static void loadTView()throws IOException{
        FileReader fr = null;
        try{
            fr = new FileReader("./src/main/java/com/huhyn/swissstyle/AllTournements.txt");
        }
        catch (FileNotFoundException fe){
            System.out.println("File not found");
        }
        BufferedReader br = new BufferedReader(fr);
        String str;
        while ((str = br.readLine())!= null){
            String temp= str;
            str= br.readLine();
            temp = temp + ", " + str;
            tornementView.add(temp);
        }
        fr.close();
    }
    public static void newTournement(){
        Tornement newT = new Tornement();
        t.add(newT);
        curr = newT;
    }
    
    public static void loadTournement(String Name)throws IOException{
            curr = new Tornement();
            FileReader fr = null;
            Name = Name.split(",")[0];
            try{
                fr = new FileReader("./src/main/java/com/huhyn/swissstyle/"+ Name+".txt");

            }
            catch (FileNotFoundException fe){
                System.out.println("File not found");
            }
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine())!= null){
                //name
                curr.name = str;
                //description
                str= br.readLine();
                curr.description = str;
                //people
                str= br.readLine();
                 while ((str= br.readLine())!="####"){
                    String n = str;//name
                    String c = br.readLine();//club
                    int r = Integer.parseInt(br.readLine());//rating
                    int w = Integer.parseInt(br.readLine());//wins
                    Person temp = new Person(n,c,r,w);
                    curr.people.add(temp);
                    str= br.readLine();//"----" seperator for readabilty   
                }
                //rounds
                while ((str= br.readLine())!="####"){
                    while ((str= br.readLine())!="++++"){//round seperatpr
                    
                    }
                }
                String temp= str;
                temp = temp + " " + str;
                tornementView.add(temp);
            }
            fr.close();
        }
    
    public static void save()throws IOException{
        String name = curr.name.replaceAll(" ","_");
        File newT = new File("./src/main/java/com/huhyn/swissstyle/"+name+".txt");
        newT.createNewFile();
        FileWriter fWriter = new FileWriter("./src/main/java/com/huhyn/swissstyle/"+name+".txt");
        FileWriter tWriter = new FileWriter("./src/main/java/com/huhyn/swissstyle/AllTournements.txt");
        fWriter.write(curr.name+"\n");
        tWriter.write(curr.name+"\n");
        fWriter.write(curr.description+"\n");
        tWriter.write(curr.description+"\n");
        fWriter.write("####\n");
        for (int i =0; i<curr.people.size();i++){
            fWriter.write(curr.people.get(i).name+"\n");
            fWriter.write(curr.people.get(i).club+"\n");
            fWriter.write(curr.people.get(i).rating+"\n");
            fWriter.write(curr.people.get(i).win+"\n");
            fWriter.write("----\n");
        }
        fWriter.write("####\n");
        for (int i =0; i<curr.tornement.size();i++){
            for (int j =0; j<curr.tornement.get(i).game.size();j++){
                fWriter.write(curr.tornement.get(i).game.get(j).one.name+"\n");
                fWriter.write(curr.tornement.get(i).game.get(j).two.name+"\n");
                fWriter.write(curr.tornement.get(i).game.get(j).score+"\n");
                fWriter.write("----\n");
            }
            fWriter.write("++++\n");
        }
        fWriter.close();
        tWriter.close();
    }
    public static Tornement getCurr(){
        return curr;
    }
    
    public static int getSize(){
        return t.size();
    }
    
    public static void addTournement(String n){
        tornementView.add(n);
    }
    
    public static void setCurrName(String n){
        curr.name = n;
    }
    
    public static void main(String[] args) {
        launch();
    }

}