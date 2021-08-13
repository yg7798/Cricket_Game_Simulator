package com.example.gamecricket.services;

import com.example.gamecricket.entities.Match;
import com.example.gamecricket.entities.TossResult;
import com.example.gamecricket.request_dto.MatchRequest;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.response_dto.MatchSummary;

import java.util.List;

public interface MatchService {
    List<Match> getAllMatches();
    BaseResponse createMatch(MatchRequest matchRequest);
    BaseResponse updateMatch(int id, Match match);
    BaseResponse deleteMatch(int id);
    Match getMatch(int id);
    MatchSummary getMatchSummary(int matchID);
    MatchSummary matchStart(int matchID);
    TossResult startToss(int matchID);
}
