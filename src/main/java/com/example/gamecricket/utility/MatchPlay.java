package com.example.gamecricket.utility;

import com.example.gamecricket.entities.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MatchPlay {
    public static void  play(int overs, Team battingTeam, int targetRuns, boolean secondTeam, Team bowlingTeam, ArrayList wicketInfo, Innings innings)
    {
        List<Player>battingTeamPlayers=battingTeam.getPlayers();
        List<Player>bowlingTeamPlayers=bowlingTeam.getPlayers();
        List<Over>overList=new LinkedList<>();
        List<Wicket>wicketList=new LinkedList<>();
        int i,j;
        int runs=0;
        int t1=0,t2=5;
        int p1=0,p2=1;
        for( i=1;i<=overs;i++) {
            if(t2>10) t2=5;
            int currentBowler=bowlingTeamPlayers.get(t2).getPlayerId();
            Over over=new Over();
            List<RunOrWicket>runOrWickets=new LinkedList<>();
            for (j = 1; j <= 6; j++) {
                if (battingTeam.getWickets() >= 10 || (secondTeam && targetRuns < battingTeam.getTotalRuns())) {
                    break;
                }
                int possible_run = GetRunsOrWickets.myRandom();
                battingTeamPlayers.get(p1).setBallsFaced(battingTeamPlayers.get(p1).getBallsFaced()+1);
                if (possible_run == -1) {
                    bowlingTeamPlayers.get(t2).setWicketsTaken(bowlingTeamPlayers.get(t2).getWicketsTaken()+1);
                    battingTeam.setWickets(battingTeam.getWickets() + 1);
                    int currentBatsman=battingTeamPlayers.get(t1).getPlayerId();
                    Wicket wicket=new Wicket();
                    wicket.setWicketTakeBy(currentBowler);
                    wicket.setWhoGotOut(currentBatsman);
                    wicket.setOver(over);
                    wicket.setBatsmanTeamNo(battingTeam.getTeamNo());
                    wicket.setBowlerTeamNo(bowlingTeam.getTeamNo());
                    wicketInfo.add(wicket);
                    wicketList.add(wicket);
                    t1=t1+1;
                    p1=(battingTeamPlayers.get(t1).getPlayerId())%11;
                    runOrWickets.add(RunOrWicket.WICKET);
                } else if (possible_run == 0) {
                    battingTeam.setDotBalls(battingTeam.getDotBalls() + 1); runOrWickets.add(RunOrWicket.DOT_BALL);
                } else if (possible_run == 1) {
                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 1); runs+=1; runOrWickets.add(RunOrWicket.ONE);
                    battingTeamPlayers.get(p1).setRunsScored(battingTeamPlayers.get(p1).getRunsScored()+1);
                    int temp=p1; p1=p2; p2=temp;  // change strike
                } else if (possible_run == 2) {
                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 2); runs+=2;  runOrWickets.add(RunOrWicket.TWO);
                    battingTeamPlayers.get(p1).setRunsScored(battingTeamPlayers.get(p1).getRunsScored()+2);
                } else if (possible_run == 3) {
                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 3); runs+=3;  runOrWickets.add(RunOrWicket.THREE);
                    battingTeamPlayers.get(p1).setRunsScored(battingTeamPlayers.get(p1).getRunsScored()+3);
                    int temp=p1; p1=p2; p2=temp;  // change strike
                } else if (possible_run == 4) {
                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 4);
                    battingTeam.setFours(battingTeam.getFours() + 1);         runs+=4;  runOrWickets.add(RunOrWicket.FOUR);
                    battingTeamPlayers.get(p1).setRunsScored(battingTeamPlayers.get(p1).getRunsScored()+4);
                } else if (possible_run == 5) {
                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 5); runs+=5;   runOrWickets.add(RunOrWicket.FIVE);
                } else {
                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 6);  runs+=6;   runOrWickets.add(RunOrWicket.SIX);
                    battingTeam.setSixes(battingTeam.getSixes() + 1);
                    battingTeamPlayers.get(p1).setRunsScored(battingTeamPlayers.get(p1).getRunsScored()+6);
                }
            }
            over.setRunOrWickets(runOrWickets);
            overList.add(over);
            int temp=p1; p1=p2; p2=temp;  // change strike
            bowlingTeamPlayers.get(t2).setOversBalled(bowlingTeamPlayers.get(t2).getOversBalled()+1);
            bowlingTeamPlayers.get(t2).setRunsGiven(bowlingTeamPlayers.get(t2).getRunsGiven()+runs);
            t2=t2+1;
            runs=0;
        }
        innings.setWickets(wicketList);
        innings.setOvers(overList);
        battingTeam.setBallsPlayed(i*6);
    }

}
