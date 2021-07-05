package com.example.gamecricket.entities;

public class Player {
    private int playerTeam;  // team for which he play
    private int playerId;  // jersey no.
    private Role role;

    public Player(int playerTeam,int playerId,Role role)
    {
        this.playerTeam=playerTeam;
        this.playerId=playerId;
        this.role=role;
    }
}
