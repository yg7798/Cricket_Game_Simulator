package com.example.gamecricket.response_dto;

import com.example.gamecricket.entities.Innings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchSummary {
    private String message;
    private int matchNo;
    private Innings innings1;
    private Innings innings2;
}
