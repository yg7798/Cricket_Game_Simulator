package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Match {
    private String venue;
    private int noOfOvers;
    Team team1,team2;
    private String dateAndTime;
    Innings innings1,innings2;
}
