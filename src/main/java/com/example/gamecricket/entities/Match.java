package com.example.gamecricket.entities;

import com.example.gamecricket.utility.MatchUtil;
import com.example.gamecricket.utility.Results;
import com.example.gamecricket.utility.TeamUtil;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

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
        Over over=new Over(overs);
        over.setOverNo(overs);
        get_teams();
        Team teams1 = TeamUtil.createTeam1(team1);
        Team teams2 = TeamUtil.createTeam2(team2);
        MatchUtil matchUtil = new MatchUtil(venue, overs, teams1, teams2, null, null);
        if (Toss.startToss()) {
            matchUtil.setFirst(teams1);
            MatchPlay.play(over,teams1, Integer.MAX_VALUE, false);
            matchUtil.setSecond(teams2);
            MatchPlay.play( over,teams2, teams1.getTotalRuns(), true);
            System.out.println(Results.getResult(matchUtil,teams1,teams2));
        } else {
            matchUtil.setFirst(teams2);
            MatchPlay.play( over,teams2, Integer.MAX_VALUE, false);
            matchUtil.setSecond(teams1);
            MatchPlay.play( over,teams1, teams2.getTotalRuns(), true);
            System.out.println(Results.getResult(matchUtil,teams2,teams1));
        }

    }
}