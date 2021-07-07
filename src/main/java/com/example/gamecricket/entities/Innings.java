package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Innings {
    Team battingTeam,bowlingTeam;
    List<Wicket>wickets;
    List<Over>overs;
    private int runsToBeat;
    private int totalRuns;
    private int dotBalls;
    private int sixes;
    private int fours;
    private int wicketsDown;
    private int ballsPlayed;
    private boolean isChasing;
}
