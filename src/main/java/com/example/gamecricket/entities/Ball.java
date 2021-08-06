package com.example.gamecricket.entities;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`ball`")
public class Ball {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ballID;
  private int ballNo;
  private int strikerId;
  private int nonStrikerId;
  private int bowlerId;

  //private Player striker,nonStriker;
  private int overNo;
  @Enumerated(EnumType.STRING)
  private RunOrWicket runOrWicket;

  private int matchNo;
  private  int inningsNo;
}
