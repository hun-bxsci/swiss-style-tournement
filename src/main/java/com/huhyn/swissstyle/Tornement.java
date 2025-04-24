package com.huhyn.swissstyle;

import java.util.ArrayList;
import java.util.List;

public class Tornement {
    List<Round> tornement;
    List<Person> people;
    String name;
    String description;
    public Tornement(){
        
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
        Round r = new Round();
        // do logic here
    }
    public void addPerson(String name, String club, int rating){
        Person p = new Person(name, club, rating);
        people.add(p);
    }
}
