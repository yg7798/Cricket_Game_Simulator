package com.example.gamecricket.services;

import com.example.gamecricket.entities.*;
import com.example.gamecricket.repository.MatchRepo;
import com.example.gamecricket.response_dto.MatchResponse;
import com.example.gamecricket.response_dto.PlayerResponse;
import com.example.gamecricket.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private int battingTeamID;
    private int bowlingTeamID;
    PlayerResponse playerResponse=new PlayerResponse();
    @Autowired
    private  MatchRepo matchRepo;

    @Autowired
    private InningsService inningsService;

    @Autowired
    private TeamService teamService;

    public List<Match> getAllMatches()
    {
        List<Match>matches=new ArrayList<>();
        matchRepo.findAll().forEach(matches::add);
        return matches;
    }
    public  void createMatch(Match match)
    {
        matchRepo.save(match);
    }

    public void updateMatch(int id, Match match) {
        matchRepo.save(match);
    }

    public Match getMatch(int id) {
        Optional<Match> matches = matchRepo.findById(id);
        return matches.orElse(matches.get());
    }

    public void deleteMatch(int id) {
        matchRepo.deleteById(id);
    }

    public String startToss(int id1,int id2)
    {
        String result= Toss.startToss();
        if (result== Constants.HEAD)
        {
            battingTeamID=id1;
            bowlingTeamID=id2;
            return "team "+id1+" will bat first";
        }
        else
        {
            battingTeamID=id2;
            bowlingTeamID=id1;
            return "team "+id2+" will bat first";
        }
    }
    public MatchResponse matchStart(int matchID)  {
        Match match=getMatch(matchID);
        Innings innings1=new Innings();
        innings1.setBattingTeamId(battingTeamID);
        innings1.setBowlingTeamId(bowlingTeamID);
        innings1.setInningsNo(1);
        innings1.setMatchNo(matchID);
        inningsService.startInnings(innings1,Integer.MAX_VALUE,false,match.getNoOfOvers());
        int target=innings1.getTotalRuns();
        Innings innings2=new Innings();
        innings2.setBattingTeamId(bowlingTeamID);
        innings2.setBowlingTeamId(battingTeamID);
        innings2.setInningsNo(2);
        innings2.setMatchNo(matchID);
        inningsService.startInnings(innings2,target+1,true,match.getNoOfOvers());
        playerResponse.setMatchID(matchID);
        playerResponse.setTeam1(teamService.getTeamById(battingTeamID));
        playerResponse.setTeam2(teamService.getTeamById(bowlingTeamID));
        String message="";
        if(target>innings2.getTotalRuns()){message=teamService.getTeamById(battingTeamID).getTeamName()+" team won";}
        else if(innings2.getTotalRuns()>target){message=teamService.getTeamById(bowlingTeamID).getTeamName()+" team won";}
        else{
             message="Draw";
        }
        return new MatchResponse(message,innings1,innings2);
    }

    public PlayerResponse getPlayerResponse()
    {
        return playerResponse;
    }
}
