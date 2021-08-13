package com.example.gamecricket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`ball`")
public class Ball extends Base{

  @JsonIgnore
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ballID;
  private int ballNo;
  private int strikerId;
  private int nonStrikerId;
  private int bowlerId;
  private int overNo;
  private int runsScored;
  private boolean isWicketFall;
  private int matchNo;
  private  int inningsNo;
}
