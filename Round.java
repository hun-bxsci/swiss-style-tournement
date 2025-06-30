package com.huhyn.swissstyle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhyhu
 */
public class Round {
    List<Game> game;
    boolean set = false;
    boolean done = false;
    public Round(){
        game = new ArrayList<Game>();
    }
    public void swap(Game g1, Game g2){
        Person temp = g1.one;
        g1.one = g2.one;
        g2.one = temp;
    }
    public void addGame(Game g){
        game.add(g);
    }
}
