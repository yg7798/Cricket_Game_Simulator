package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchUtil {
    private String venue;
    private int noOfOvers;
    Team team1,team2,first,second;
}
