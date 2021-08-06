package com.example.gamecricket.controller;


import com.example.gamecricket.entities.Match;
import com.example.gamecricket.response_dto.MatchResponse;
import com.example.gamecricket.response_dto.PlayerResponse;
import com.example.gamecricket.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;


    @GetMapping("/matches")
    public List<Match> getAllMatches()
    {
         return matchService.getAllMatches();
    }

   @RequestMapping(method = RequestMethod.POST,value = "/matches")
   public void createMatch(@RequestBody Match match)
    {
        matchService.createMatch(match);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/matches/{id}")
    public void updateMatch(@RequestBody Match match,@PathVariable int id)
    {
        matchService.updateMatch(id,match);
    }

    @RequestMapping("/matches/{id}")
    public Match getMatch(@PathVariable int id)
    {
        return matchService.getMatch(id);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/matches/{id}")
    public void deleteMatch(@PathVariable int id)
    {
        matchService.deleteMatch(id);
    }

    @GetMapping("/match/toss/{id1}/{id2}")
    public String startToss(@PathVariable int id1,@PathVariable int id2)
    {
        return matchService.startToss(id1,id2);
    }

    @GetMapping("/match/start/{id}")
    public MatchResponse matchStart(@PathVariable int id)
    {
        return matchService.matchStart(id);
    }

    @GetMapping("/match/start/players")
    public PlayerResponse matchStart()
    {
        return matchService.getPlayerResponse();
    }

}
