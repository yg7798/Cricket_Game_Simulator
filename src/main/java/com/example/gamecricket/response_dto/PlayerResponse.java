package com.example.gamecricket.response_dto;

import com.example.gamecricket.entities.Player;
import com.example.gamecricket.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerResponse {
    private int matchID;
    Team team1;
    Team team2;
}
