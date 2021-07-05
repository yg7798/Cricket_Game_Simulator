package com.example.gamecricket.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Team {
    private List<Player> players;
    private int teamNo;
    private int runsToBeat;
    private int totalRuns;
    private int dotBalls;
    private int sixes;
    private int fours;
    private int wickets;
    private int ballsPlayed;
}
