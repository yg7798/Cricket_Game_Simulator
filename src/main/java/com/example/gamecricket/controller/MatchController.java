package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Match;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;


public class MatchController {

    public static void main(String args[]) throws InterruptedException {
        Match.matchStart();
    }

}
