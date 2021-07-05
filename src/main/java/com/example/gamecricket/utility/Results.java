package com.example.gamecricket.utility;

import com.example.gamecricket.entities.Innings;
import com.example.gamecricket.entities.Team;

import java.util.Date;

public class Results {
    public static String getResult(MatchUtil match, Team first, Team second) {

        //System.out.println("Hello everyone "+match.getNoOfOvers()+" over match is scheduled between team "+first.getTeamNo()+" and "+second.getTeamNo()+" at "+match.getVenue()+" on "+new Date().toString());
        int firstInningScore;
        int secondInningScore;

        firstInningScore=first.getTotalRuns();
        System.out.println("sore of first inning is "+firstInningScore);
        firstInningScore=firstInningScore+1;
        System.out.println("second team need "+firstInningScore+" runs to win");
        secondInningScore=second.getTotalRuns();
        System.out.println("Second team scored "+second.getTotalRuns()+" runs");
        if(firstInningScore>secondInningScore){return "First team won";}
        else if(secondInningScore>firstInningScore){return "second team win";}
        else{
            return "Draw";
        }
    }
}
