package com.example.gamecricket.response_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatsmanResponse {
    private Integer matchNumber;
    private Integer playerNumber;
    private int runsScored;
    private int ballsPlayed;
}
