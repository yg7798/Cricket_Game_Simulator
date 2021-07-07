package com.example.gamecricket.utility;

import com.example.gamecricket.entities.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class StartMatchUtil  {
    private static int team1;
    private static int team2;

    public StartMatchUtil() {

    }

    public static void get_teams() {
        Random random = new Random();
        team1 = 1 + random.nextInt(9); // gives id from 1 to 9 means that it choose any team from 9 teams
        team2 = 1 + random.nextInt(9);
        while (true) {
            if (team1 == team2) {
                team2 = 1 + random.nextInt(9);
            } else {
                break;
            }
        }
    }

    public static void matchStart()  {
        Scanner sc = new Scanner(System.in);
        String venue = sc.next();
        int overs = sc.nextInt();  // Ex -10,20,50
        get_teams();
        Team teams1 = TeamUtil.createTeam1(team1);
        Team teams2 = TeamUtil.createTeam2(team2);
        Match match = new Match(venue, overs, teams1, teams2,null,null,null);
        match.setDateAndTime(new Date().toString());
        if (Toss.startToss()=="Head") {
            Innings innings1=new Innings();  innings1.setBattingTeam(teams1);  innings1.setBowlingTeam(teams2);
            MatchPlay.play(overs, Integer.MAX_VALUE, false,innings1);
            /*ScoreBoard.printScoreBoard(innings1);*/match.setInnings1(innings1);
            int target=innings1.getTotalRuns();
            Innings innings2=new Innings();  innings2.setBattingTeam(teams2);  innings2.setBowlingTeam(teams1);
            MatchPlay.play( overs, target, true,innings2);
            /*ScoreBoard.printScoreBoard(innings2);*/  match.setInnings2(innings2);
            System.out.println(Results.getResult(match));
        } else {
            Innings innings1=new Innings();  innings1.setBattingTeam(teams2);  innings1.setBowlingTeam(teams1);
            MatchPlay.play( overs, Integer.MAX_VALUE, false,innings1);
           /* ScoreBoard.printScoreBoard(innings1);*/   match.setInnings1(innings1);
            int target=innings1.getTotalRuns();
            Innings innings2=new Innings();  innings2.setBattingTeam(teams1);  innings2.setBowlingTeam(teams2);
            MatchPlay.play( overs,target, true,innings2);
            /*ScoreBoard.printScoreBoard(innings2); */  match.setInnings2(innings2);
            System.out.println(Results.getResult(match));
        }
    }
}