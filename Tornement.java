package com.huhyn.swissstyle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tornement {
    List<Round> tornement;
    List<Person> people;
    String name;
    String description;
    public Tornement(){
        tornement = new ArrayList<Round>();
        people = new ArrayList<Person>(); 
    }
    public Tornement(String n, String d){
        name = n;
        description = d;
        tornement = new ArrayList<Round>();
        people = new ArrayList<Person>();
    }
    public void updateDesc(String s){
        description = s;
    }
    public void newRound(){
        // do logic here
        //sort ppl list by comparitor/wins
        Round r = new Round();
        Comparator<Person> byWins = Comparator.comparing(Person::wins);
       people.sort(byWins);
        //pair 1,2  3,4 etc
        for (int i =0; i<people.size(); i+=2){
            Game temp = new Game(people.get(i),people.get(i+1));
            r.addGame(temp);
        }
        tornement.add(r);
    }
    public void initialROund(){
        Round r = new Round();
        //sort by rating, make comaprator
        Comparator<Person> byRating = Comparator.comparing(Person::rating);
        people.sort(byRating);
        //not accounting club for now
        for (int i =0; i<people.size(); i+=2){
            Game temp = new Game(people.get(i),people.get(i+1));
            r.addGame(temp);
        }
        //pair 1,2 3,4 unless same club (disregard if no club)
        tornement.add(r);
    }
    public void addPerson(String name, String club, int rating){
        Person p = new Person(name, club, rating);
        people.add(p);
    }
    public void save(){
        //create file if new
        //save only name of players for games
        for (int i =0; i<tornement.size(); i++){
            //save 
        }
    }
}
