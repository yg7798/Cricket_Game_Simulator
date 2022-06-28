package com.example.gamecricket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`match`")
public class Match extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchID;

    @Column
    private String venue;

    @Column(name = "overs")
    private int noOfOvers;

    @Column
    private int teamId1;

    @Column
    private int teamId2;

}
