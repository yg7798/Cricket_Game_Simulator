package com.example.gamecricket.response_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BowlerResponse {
    private Integer matchNumber;
    private Integer playerNumber;
    private int runsGiven;
    private int oversBalled;
    private int wicketsTaken;
}
