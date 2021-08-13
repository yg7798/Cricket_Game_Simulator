package com.example.gamecricket.services;

import com.example.gamecricket.entities.Player;
import com.example.gamecricket.request_dto.PlayerRequest;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.response_dto.PlayerSummary;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();
    BaseResponse createPlayer(PlayerRequest playerRequest);
    BaseResponse updatePlayer(int id, Player player);
    Player getPlayer(int id);
    BaseResponse createListPlayers(List<Player>players);
    BaseResponse deletePlayer(int id);
    PlayerSummary setPlayerSummaryForMatch(int matchNo, int inningsNo);
}
