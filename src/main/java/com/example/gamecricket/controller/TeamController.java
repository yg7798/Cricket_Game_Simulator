package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Team;
import com.example.gamecricket.exception.NotFoundException;
import com.example.gamecricket.request_dto.TeamRequest;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.services.TeamService;
import com.example.gamecricket.services.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<?> getTeamById(@PathVariable int teamId) {
        Team team=teamService.getTeamById(teamId);
        if(team.getTeamID()==0)
        {
            throw new NotFoundException("TeamId "+teamId+" NOT FOUND");
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping
    public BaseResponse addTeam(@Valid @RequestBody TeamRequest teamRequest) {
        return teamService.addTeam(teamRequest);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public BaseResponse updateTeam(@RequestBody Team team, @PathVariable int id)
    {
        return teamService.updateTeam(id,team);
    }
}
