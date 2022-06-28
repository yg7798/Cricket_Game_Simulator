package com.example.gamecricket.interfaces;

import com.example.gamecricket.entities.Player;

import java.util.Comparator;

public class PlayerAverageComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getAverage()<o2.getAverage())
            return 1;
        else if(o1.getAverage()>o2.getAverage())
            return -1;
        return 0;
    }
}
