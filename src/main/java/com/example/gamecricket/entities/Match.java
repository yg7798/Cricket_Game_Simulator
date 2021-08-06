package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "`match`")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchID;

    @Column
    private String venue;

    @Column(name = "overs")
    private int noOfOvers;

    @Column
    private String dateAndTime;

    @Column
    private int teamId1;

    @Column
    private int teamId2;

    public Match() {

    }

    // private Team team1,team2;
   // private Innings innings1,innings2;
}
