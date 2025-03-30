package com.huhyn.swissstyle;

/**
 *
 * @author nhyhu
 */
public class Round {
    Game[] game;
    boolean set = false;
    boolean done = false;
    public Round(String[] testing){
        
    }
    public void swap(Game g1, Game g2){
        Person temp = g1.one;
        g1.one = g2.one;
        g2.one = temp;
    }
}
