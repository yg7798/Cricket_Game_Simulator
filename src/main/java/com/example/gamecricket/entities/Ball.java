package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Ball {
  Player striker,nonStriker;
  private int overNo;
  RunOrWicket runOrWicket;
}
