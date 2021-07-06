package com.example.gamecricket.utility;

import com.example.gamecricket.entities.*;

import java.util.*;

public class Match extends Thread {
    private static int team1;
    private static int team2;

    public Match() {

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

    public static void matchStart() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String venue = sc.next();
        int overs = sc.nextInt();  // Ex -10,20,50
        get_teams();
        Team teams1 = TeamUtil.createTeam1(team1);
        Team teams2 = TeamUtil.createTeam2(team2);
        MatchUtil matchUtil = new MatchUtil(venue, overs, teams1, teams2, null, null);
        ArrayList<Wicket>wicketsInfo=new ArrayList<>();
        if (Toss.startToss()=="Head") {
            Innings innings1=new Innings();  innings1.setBattingTeam(teams1);  innings1.setBowlingTeam(teams2);
            matchUtil.setFirst(teams1);
            MatchPlay.play(overs,teams1, Integer.MAX_VALUE, false,teams2,wicketsInfo,innings1);
            ScoreBoard.printScoreBoard(innings1);
            Innings innings2=new Innings();  innings2.setBattingTeam(teams2);  innings2.setBowlingTeam(teams1);
            matchUtil.setSecond(teams2);
            MatchPlay.play( overs,teams2, teams1.getTotalRuns(), true,teams1,wicketsInfo,innings2);
            ScoreBoard.printScoreBoard(innings2);
            System.out.println(Results.getResult(matchUtil,teams1,teams2));
        } else {
            Innings innings1=new Innings();  innings1.setBattingTeam(teams2);  innings1.setBowlingTeam(teams1);
            matchUtil.setFirst(teams2);
            MatchPlay.play( overs,teams2, Integer.MAX_VALUE, false,teams1,wicketsInfo,innings1);
            ScoreBoard.printScoreBoard(innings1);
            Innings innings2=new Innings();  innings2.setBattingTeam(teams1);  innings2.setBowlingTeam(teams2);
            matchUtil.setSecond(teams1);
            MatchPlay.play( overs,teams1, teams2.getTotalRuns(), true,teams2,wicketsInfo,innings2);
            ScoreBoard.printScoreBoard(innings2);
            System.out.println(Results.getResult(matchUtil,teams2,teams1));
        }
    }
}