package com.huhyn.swissstyle;

import java.util.Comparator;

/**
 *
 * @author nhyhu
 */
public class Person {
    String name;
    String club;
    int win;
    int rating;
    public Person(String n, String c, int r){
        name = n;
        club = c;
        rating = r;
        win =0;
    }
    public Person(String n, String c, int r, int w){
        name = n;
        club = c;
        rating = r;
        win =w;
    }
    public int rating(){
        return rating;
    }
    public int wins(){
        return win;
    }
}



