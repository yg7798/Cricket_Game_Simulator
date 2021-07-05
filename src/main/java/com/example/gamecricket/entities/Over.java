package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Over extends Thread{
    private  int overNo;
}
