package com.example.gamecricket.interfaces;

import com.example.gamecricket.entities.Player;

import java.util.List;

public class DecideNextPlayerImpl implements DecideNextPlayer {

    @Override
    public Player getNextBatsmanByAverage(List<Player> battingTeamPlayers) {
        return null;
    }

    @Override
    public Player getNextBowlerByEconomy(List<Player> bowlingTeamPlayers) {
        return null;
    }
}
