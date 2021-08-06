package com.example.gamecricket.services;

import com.example.gamecricket.entities.Team;
import com.example.gamecricket.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        teamRepo.findAll().forEach(teams::add);
        return teams;
    }
    public void addTeam(Team team) {
        teamRepo.save(team);
    }
    public Team getTeamById(int teamId) {
        Optional<Team> team = teamRepo.findById(teamId);
        return team.orElseGet(Team::new);
    }
    public Team updateTeam(int teamId, Team team) {
        return teamRepo.save(team);
    }


}
