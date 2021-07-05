package com.example.gamecricket.entities;

import java.util.Random;

public class Toss {
    public static boolean startToss(){
        return (int)(Math.random() * 10) == 0? true : false ;
    }

}
