package com.example.gamecricket.utility;

public class Toss {
    public static String startToss(){
        return (int)(Math.random() * 10) == 0? "Head" : "Tail" ;
    }
}
