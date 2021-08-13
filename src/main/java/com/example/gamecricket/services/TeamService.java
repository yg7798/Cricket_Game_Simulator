package com.example.gamecricket.services;

import com.example.gamecricket.entities.Team;
import com.example.gamecricket.request_dto.TeamRequest;
import com.example.gamecricket.response_dto.BaseResponse;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();
    BaseResponse addTeam(TeamRequest teamRequest);
    BaseResponse updateTeam(int teamId, Team team);
    Team getTeamById(int teamId);
}
