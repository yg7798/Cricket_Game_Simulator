package com.example.gamecricket.response_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSummary {
   private List<BatsmanResponse>batsmanResponses;
   private List<BowlerResponse>bowlingResponses;
}
