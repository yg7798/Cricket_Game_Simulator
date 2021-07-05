package com.example.gamecricket.entities;

public class Wicket {
  public static int current_wickets_down=0;
    public Wicket()
    {

    }

    public void updateWickets()
    {
        current_wickets_down++;
    }
    public int getCurrent_wickets_down()
    {
        return current_wickets_down;
    }
    public int check_wickets()
    {
        if(current_wickets_down==10)
        {
            return 1;
        }
        return 0;
    }

}
