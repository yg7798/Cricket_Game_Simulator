package com.example.gamecricket.utility;

import com.example.gamecricket.entities.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MatchPlay {
    public static void  play(int overs, int targetRuns, boolean secondTeam, Innings innings)
    {
        List<Player>battingTeamPlayers=innings.getBattingTeam().getPlayers();
        List<Player>bowlingTeamPlayers=innings.getBowlingTeam().getPlayers();
        innings.setChasing(secondTeam);
        List<Over>overList=new LinkedList<>();
        List<Wicket>wicketList=new LinkedList<>();
        int i,j;
        int runs=0;
        int decideBatsman=0,decideBowler=5;
        int strikerID=0,nonStrikerID=1;
        for( i=1;i<=overs;i++) {
            if(decideBowler>10) decideBowler=5;
            int currentBowler=bowlingTeamPlayers.get(decideBowler).getPlayerId();
            Over over=new Over();
            over.setBowler(bowlingTeamPlayers.get(decideBowler));
            List<Ball>balls=new LinkedList<>();
            for (j = 1; j <= 6; j++) {
                if (innings.getWicketsDown() >= 10 || (secondTeam && targetRuns < innings.getTotalRuns())) {
                    break;
                }
                Ball ball=new Ball(battingTeamPlayers.get(strikerID),battingTeamPlayers.get(nonStrikerID),i,null);
                int possible_run = RandomGeneratorUtil.myRandom();
                battingTeamPlayers.get(strikerID).setBallsFaced(battingTeamPlayers.get(strikerID).getBallsFaced()+1);
                if (possible_run == -1) {
                    bowlingTeamPlayers.get(decideBowler).setWicketsTaken(bowlingTeamPlayers.get(decideBowler).getWicketsTaken()+1);
                    innings.setWicketsDown(innings.getWicketsDown() + 1);
                    int currentBatsman=battingTeamPlayers.get(decideBatsman).getPlayerId();
                    Wicket wicket=new Wicket(currentBowler,currentBatsman,innings.getBowlingTeam().getTeamNo(),innings.getBattingTeam().getTeamNo(),over);
                    wicketList.add(wicket);
                    decideBatsman=decideBatsman+1;
                    strikerID=(battingTeamPlayers.get(decideBatsman).getPlayerId())%11; ball.setRunOrWicket(RunOrWicket.WICKET);
                    balls.add(ball);
                } else if (possible_run == 0) {
                    innings.setDotBalls(innings.getDotBalls() + 1); ball.setRunOrWicket(RunOrWicket.DOT_BALL);
                    balls.add(ball);
                } else if (possible_run == 1) {
                    innings.setTotalRuns(innings.getTotalRuns() + 1); runs+=1;
                    battingTeamPlayers.get(strikerID).setRunsScored(battingTeamPlayers.get(strikerID).getRunsScored()+1);
                    int temp=strikerID; strikerID=nonStrikerID; nonStrikerID=temp;  // change strike
                    ball.setRunOrWicket(RunOrWicket.ONE);
                    balls.add(ball);
                } else if (possible_run == 2) {
                    innings.setTotalRuns(innings.getTotalRuns() + 2); runs+=2;
                    battingTeamPlayers.get(strikerID).setRunsScored(battingTeamPlayers.get(strikerID).getRunsScored()+2);
                    ball.setRunOrWicket(RunOrWicket.TWO);
                    balls.add(ball);
                } else if (possible_run == 3) {
                    innings.setTotalRuns(innings.getTotalRuns() + 3); runs+=3;
                    battingTeamPlayers.get(strikerID).setRunsScored(battingTeamPlayers.get(strikerID).getRunsScored()+3);
                    int temp=strikerID; strikerID=nonStrikerID; nonStrikerID=temp;  // change strike
                    ball.setRunOrWicket(RunOrWicket.THREE);
                    balls.add(ball);
                } else if (possible_run == 4) {
                    innings.setTotalRuns(innings.getTotalRuns() + 4);
                    innings.setFours(innings.getFours() + 1);         runs+=4;
                    battingTeamPlayers.get(strikerID).setRunsScored(battingTeamPlayers.get(strikerID).getRunsScored()+4);
                    ball.setRunOrWicket(RunOrWicket.FOUR);
                    balls.add(ball);
                } else if (possible_run == 5) {
                    innings.setTotalRuns(innings.getTotalRuns() + 5); runs+=5;
                    ball.setRunOrWicket(RunOrWicket.FIVE);
                    balls.add(ball);
                } else {
                    innings.setTotalRuns(innings.getTotalRuns() + 6);  runs+=6;
                    innings.setSixes(innings.getSixes() + 1);
                    battingTeamPlayers.get(strikerID).setRunsScored(battingTeamPlayers.get(strikerID).getRunsScored()+6);
                    ball.setRunOrWicket(RunOrWicket.SIX);
                    balls.add(ball);
                }
                ScoreBoard.printScoreBoard(ball);
            }
            over.setBallInfo(balls);
            overList.add(over);
            int temp=strikerID; strikerID=nonStrikerID; nonStrikerID=temp;  // change strike
            bowlingTeamPlayers.get(decideBowler).setOversBalled(bowlingTeamPlayers.get(decideBowler).getOversBalled()+1);
            bowlingTeamPlayers.get(decideBowler).setRunsGiven(bowlingTeamPlayers.get(decideBowler).getRunsGiven()+runs);
            decideBowler=decideBowler+1;
            runs=0;
        }
        innings.setWickets(wicketList);
        innings.setOvers(overList);
        innings.setBallsPlayed(i*6);
    }

}
