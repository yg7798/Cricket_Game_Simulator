package com.example.gamecricket.entities;

import com.example.gamecricket.utility.GetRunsOrWickets;

public class MatchPlay {
    public static void  play(Over over,Team team,int targetRuns,boolean secondTeam)
    {
        int i;
        for( i=1;i<=over.getOverNo()*6;i++)
        {
            if(team.getWickets()>=10 || (secondTeam && targetRuns<team.getTotalRuns()))
            {
                break;
            }
           int  possible_run= GetRunsOrWickets.myRandom();
            System.out.println(i+" ball ");
            if(possible_run == -1) { team.setWickets(team.getWickets() + 1);System.out.println("Wicket"); }
            else if(possible_run == 0) { team.setDotBalls(team.getDotBalls() + 1); System.out.println("Dot ball");}
            else if(possible_run == 1) { team.setTotalRuns(team.getTotalRuns() + 1); System.out.println("one run");}
            else if(possible_run == 2) { team.setTotalRuns(team.getTotalRuns() + 2);System.out.println("two run"); }
            else if(possible_run == 3) { team.setTotalRuns(team.getTotalRuns() + 3);System.out.println("three run"); }
            else if(possible_run == 4) {
                team.setTotalRuns(team.getTotalRuns() + 4);
                team.setFours(team.getFours() + 1);
                System.out.println("Four");
            }
            else if(possible_run == 5){ team.setTotalRuns( team.getTotalRuns() + 5 );System.out.println("Five run"); }
            else{
                team.setTotalRuns(team.getTotalRuns() + 6);
                team.setSixes( team.getSixes() + 1);
                System.out.println("Six");
            }
        }
        team.setBallsPlayed(i);
    }

}
