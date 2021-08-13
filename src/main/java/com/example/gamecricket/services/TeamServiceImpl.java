package com.example.gamecricket.services;

import com.example.gamecricket.entities.Team;
import com.example.gamecricket.entities.TossResult;
import com.example.gamecricket.repository.TeamRepo;
import com.example.gamecricket.request_dto.TeamRequest;
import com.example.gamecricket.response_dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TeamServiceImpl implements TeamService{
    @Autowired
    private TeamRepo teamRepo;

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        teamRepo.findAll().forEach(teams::add);
        return teams;
    }
    @Override
    public BaseResponse addTeam(TeamRequest teamRequest) {
        teamRepo.save(teamRequest.getTeamFromDto());
        return new BaseResponse(true,"team added successfully",teamRequest.getTeamFromDto());
    }

    @Override
    public Team getTeamById(int teamId) {
        Optional<Team> team = teamRepo.findById(teamId);
        return team.orElseGet(Team::new);
    }
    @Override
    public BaseResponse updateTeam(int teamId, Team team) {
         teamRepo.save(team);
         return new BaseResponse(true,"team successfully updated",team);
    }
}
