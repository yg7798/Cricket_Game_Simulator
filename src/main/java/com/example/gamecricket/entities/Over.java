package com.example.gamecricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Data
public class Over{
    private List<Ball>ballInfo;
    private Player bowler;
    private int overNo;
}
