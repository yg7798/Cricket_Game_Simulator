package com.example.gamecricket.utility;

import com.example.gamecricket.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MatchUtil {
    private String venue;
    private int noOfOvers;
    Team team1,team2,first,second;

}
