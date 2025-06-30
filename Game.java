package com.huhyn.swissstyle;

/**
 *
 * @author nhyhu
 */
import java.util.ArrayList;

public class Game {
    String score="";
    Person one;
    Person two;
    public Game (Person a, Person b){
        one = a;
        two = b;
    }
    public Game (Person a, Person b, String s){
        one = a;
        two =b;
        score = s;
    }
    public void calculate(){
        int sum =0;
        String[] splited = score.split(",");
        for (String x :splited){
            if (x.contains("-")&&!(x=="-0")){
                sum--;
            }
            else if (x!="0"){
                sum++;
            }
        }
       if (sum >0){
		one.win++;
	}
	else if (sum <0){
		two.win++;
	}
    }
}
