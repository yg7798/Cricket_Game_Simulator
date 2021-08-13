package com.example.gamecricket.request_dto;

import com.example.gamecricket.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
    @NotBlank(message = "Team name is mandatory")
    private String teamName;

    public Team getTeamFromDto()
    {
          Team  team=new Team();
          team.setTeamName(teamName);
          team.setCreatedTime(System.currentTimeMillis());
          return team;
    }
}