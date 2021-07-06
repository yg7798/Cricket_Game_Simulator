package com.example.gamecricket.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Player {
    private int playerTeam;  // team for which he play
    private int playerId;  // jersey no.
    private Role role;
    private int runsScored;
    private int wicketsTaken;
    private int ballsFaced;
    private int runsGiven;
    private int oversBalled;
    public Player(int playerTeam, int playerId, Role role, int i, int i1, int i2, int i3, int i4)
    {
        this.playerTeam=playerTeam;
        this.playerId=playerId;
        this.role=role;
    }
}
