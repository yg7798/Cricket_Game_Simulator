package com.example.gamecricket.interfaces;

import com.example.gamecricket.entities.Player;

import java.util.List;

public interface DecideNextPlayer {
    Player getNextBatsmanByAverage(List<Player> battingTeamPlayers);
    Player getNextBowlerByEconomy(List<Player> bowlingTeamPlayers);
}
