package com.example.gamecricket.request_dto;

import com.example.gamecricket.entities.Match;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequest {

    private String venue;
    private int noOfOvers;
    @NotNull(message = "team id1 is mandatory")
    private Integer teamId1;
    @NotNull(message = "team id2 is mandatory")
    private Integer teamId2;

    public Match getMatchFromDto()
    {
           Match match=new Match();
            match.setVenue(venue);
            match.setNoOfOvers(noOfOvers);
            match.setTeamId1(teamId1);
            match.setTeamId2(teamId2);
            return match;
    }
}
