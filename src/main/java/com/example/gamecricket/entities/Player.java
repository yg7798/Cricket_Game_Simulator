package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "`player`")
public class Player {
   // private int playerTeam;  // team for which he play
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerID;

    @Column
    private int playerNo;  // jersey no.
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column
    private int runsScored;
    @Column
    private int wicketsTaken;
    @Column
    private int ballsFaced;
    @Column
    private int runsGiven;
    @Column
    private int oversBalled;
    @Column
    private int scored4;
    @Column
    private int scored6;
    @Column
    private double strikeRate;
    @Column
    private double average;
    @Column
    private double economy;
    /*public Player(int playerId, Role role, int i5, int i11, int i21, int i, int i1, int i2, int i3, double v1, double v, double i4)
    {
       // this.playerTeam=playerTeam;
        this.playerId=playerId;
        this.role=role;
    }*/

 public Player() {

 }
}
