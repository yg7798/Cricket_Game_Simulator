package com.example.gamecricket.controller;


import com.example.gamecricket.entities.Match;
import com.example.gamecricket.entities.TossResult;
import com.example.gamecricket.exception.NotFoundException;
import com.example.gamecricket.request_dto.MatchRequest;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.response_dto.MatchSummary;
import com.example.gamecricket.response_dto.TossResponse;
import com.example.gamecricket.services.MatchService;
import com.example.gamecricket.services.MatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;


    @GetMapping
    public List<Match> getAllMatches()
    {
         return matchService.getAllMatches();
    }

   @RequestMapping(method = RequestMethod.POST)
   public BaseResponse createMatch(@Valid @RequestBody MatchRequest matchRequest)
    {

       return matchService.createMatch(matchRequest);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public BaseResponse updateMatch(@RequestBody Match match,@PathVariable int id)
    {
       return matchService.updateMatch(id,match);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> getMatch(@PathVariable int id) {
        Match match=matchService.getMatch(id);
        if(match.getMatchID()==0)
        {
            throw new NotFoundException("MatchId "+id+" NOT FOUND");
        }
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/{id}")
    public BaseResponse deleteMatch(@PathVariable int id)
    {
        return matchService.deleteMatch(id);
    }

    @GetMapping("/toss/{id}")
    public TossResult startToss(@PathVariable int id)
    {
        return matchService.startToss(id);
    }

    @GetMapping("/start/{id}")
    public MatchSummary matchStart(@PathVariable int id)
    {
        return matchService.matchStart(id);
    }


    @GetMapping("/summary/{matchID}")
    public MatchSummary matchSummary(@PathVariable int matchID)
    {
        return matchService.getMatchSummary(matchID);
    }
}
