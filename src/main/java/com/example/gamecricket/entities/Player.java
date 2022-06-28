package com.example.gamecricket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`player`")
public class Player extends Base{
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
    private int inningsPlayed;
    @Column
    private double strikeRate;
    @Column
    private double average;
    @Column
    private double economy;

}
