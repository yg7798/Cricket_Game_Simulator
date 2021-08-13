package com.example.gamecricket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`innings`")
public class Innings extends Base {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inningsID;
    private int inningsNo;
    private int matchNo;
    private int battingTeamId;
    private int bowlingTeamId;
    private int totalRuns;
    private int dotBalls;
    private int sixes;
    private int fours;
    private int wicketsDown;
    private int ballsPlayed;
    private boolean isChasing;
}
