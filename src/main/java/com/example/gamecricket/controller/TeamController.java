package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Team;
import com.example.gamecricket.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }
    @GetMapping("/teams/{teamId}")
    public Team getTeamById(@PathVariable int teamId) {
        return teamService.getTeamById(teamId);
    }
    @PostMapping("/teams")
    public void addTeam(@RequestBody Team team) {
        teamService.addTeam(team);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/teams/{id}")
    public void updateTeam(@RequestBody Team team, @PathVariable int id)
    {
        teamService.updateTeam(id,team);
    }


}
