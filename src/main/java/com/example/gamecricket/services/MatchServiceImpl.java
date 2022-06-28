package com.example.gamecricket.services;

import com.example.gamecricket.entities.Innings;
import com.example.gamecricket.entities.Match;
import com.example.gamecricket.entities.Toss;
import com.example.gamecricket.entities.TossResult;
import com.example.gamecricket.repository.MatchRepo;
import com.example.gamecricket.repository.TossRepo;
import com.example.gamecricket.request_dto.MatchRequest;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.response_dto.MatchSummary;
import com.example.gamecricket.response_dto.TossResponse;
import com.example.gamecricket.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class MatchServiceImpl implements MatchService{

    @Autowired
    private  MatchRepo matchRepo;

    @Autowired
    private InningsServiceImpl inningsService;

    @Autowired
    private TeamServiceImpl teamService;

    @Autowired
    private TossRepo tossRepo;

    @Override
    public List<Match> getAllMatches()
    {
        List<Match>matches=new ArrayList<>();
        matchRepo.findAll().forEach(matches::add);
        return matches;
    }
    @Override
    public BaseResponse createMatch(MatchRequest matchRequest)
    {
        matchRepo.save(matchRequest.getMatchFromDto());
        return new BaseResponse(true,"match added successfully", matchRequest.getMatchFromDto());
    }

    @Override
    public BaseResponse updateMatch(int id, Match match) {
        matchRepo.save(match);
        return new BaseResponse(true,"match updated successfully",match);
    }

    @Override
    public Match getMatch(int id) {
        Optional<Match> matches = matchRepo.findById(id);
        return matches.orElseGet(Match::new);
    }

    @Override
    public BaseResponse deleteMatch(int id) {
        matchRepo.deleteById(id);
        return new BaseResponse(true,"match deleted successfully",null);
    }

    public TossResult startToss(int matchID) {
        int battingTeamID;
        int bowlingTeamID;
        TossResult tossResult = new TossResult();
        tossResult.setMatchID(matchID);
        Match match = getMatch(matchID);
        String result = Toss.startToss();
        String message = "";
        if (result == Constants.HEAD) {
            battingTeamID = match.getTeamId1();
            bowlingTeamID = match.getTeamId2();
            message += "team " + battingTeamID + " will won the toss";
        } else {
            battingTeamID = match.getTeamId2();
            bowlingTeamID = match.getTeamId1();
            message += "team " + bowlingTeamID + " will won the toss";
        }
        tossResult.setMatchID(matchID);
        tossResult.setBattingTeamID(battingTeamID);
        tossResult.setBowlingTeamID(bowlingTeamID);
        tossResult.setResult(message);
        tossRepo.save(tossResult);
        return tossResult;
    }
    public String getMatchResult(Innings innings1,Innings innings2)
    {
        String message="";
        if(innings1.getTotalRuns()>innings2.getTotalRuns()){message=teamService.getTeamById(innings1.getBattingTeamId()).getTeamName()+" team won";}
        else if(innings2.getTotalRuns()>innings1.getTotalRuns()){message=teamService.getTeamById(innings2.getBattingTeamId()).getTeamName()+" team won";}
        else{
            message="Draw";
        }
        return message;
    }

    public MatchSummary matchStart(int matchID)  {
        Match match=getMatch(matchID);
        Innings innings1=new Innings();
        TossResult tossResult=tossRepo.findByMatchID(matchID);
        int battingTeamID=tossResult.getBattingTeamID();
        int bowlingTeamID=tossResult.getBowlingTeamID();
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
        String message=getMatchResult(innings1,innings2);
        return new MatchSummary(message,matchID,innings1,innings2);
    }

    public MatchSummary getMatchSummary(int matchID)
    {
        Innings innings1=inningsService.getInningsByMatchNoAndInningsNo(matchID,1);
        Innings innings2=inningsService.getInningsByMatchNoAndInningsNo(matchID,2);
        String message=getMatchResult(innings1,innings2);
        MatchSummary matchSummary =new MatchSummary(message,matchID,innings1,innings2);
        return matchSummary;
    }

}
