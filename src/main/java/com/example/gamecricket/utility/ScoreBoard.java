package com.example.gamecricket.utility;

import com.example.gamecricket.entities.Innings;
import com.example.gamecricket.entities.Over;
import com.example.gamecricket.entities.Team;
import com.example.gamecricket.entities.Wicket;

import java.util.List;

public class ScoreBoard {
    public static void printScoreBoard(Innings innings)
    {
        Team battingTeamInfo=innings.getBattingTeam();
        Team bowlingTeamInfo=innings.getBowlingTeam();
        List<Wicket>wicketList=innings.getWickets();
        List<Over>overList=innings.getOvers();
        System.out.println(innings.getOvers().toString());
    }
}
