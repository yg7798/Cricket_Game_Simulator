package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Wicket {
  private int wicketTakeBy; // bowler player_id
  private int whoGotOut;    //batsman player_id
  private int bowlerTeamNo;
  private int batsmanTeamNo;
  private Over over;
}
