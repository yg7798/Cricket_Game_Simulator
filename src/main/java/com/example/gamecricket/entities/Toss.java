package com.example.gamecricket.entities;

import com.example.gamecricket.utility.Constants;

public class Toss {
    static Constants constants=new Constants();
    public static String startToss(){
        return (int)(Math.random() * 10) == 0? constants.HEAD : constants.TAIL;
    }
}
