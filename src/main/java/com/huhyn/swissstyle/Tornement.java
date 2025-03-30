package com.huhyn.swissstyle;

import java.util.ArrayList;

public class Tornement {
    ArrayList<Round> tornement;
    ArrayList<Person> people;
    String[] ppl;
    String description;
    public Tornement(){
        
    }
    public Tornement(String n){
        
    }
    public void updateDesc(String s){
        description = s;
    }
    public void newRound(){
        Round r = new Round(ppl);
    }
    public void addPerson(String name, String club, int rating){
        Person p = new Person(name, club, rating);
        people.add(p);
    }
}
