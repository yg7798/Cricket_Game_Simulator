package com.example.gamecricket.response_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TossResponse {
    int battingTeamId;
    String battingTeamName;
    int bowlingTeamId;
    String bowlingTeamName;
    String message;
}
