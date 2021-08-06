package com.example.gamecricket.entities;

public enum RunOrWicket {
    DOT_BALL(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    WICKET(-1);
     int label;

    RunOrWicket(int label) {
        this.label=label;
    }

    public static RunOrWicket getRun(int run) {
        if(run==-1)
        {
            return WICKET;
        }
        else if (run==0)
        {
            return DOT_BALL;
        }
        else if (run==1)
        {
            return ONE;
        }
        else if(run==2)
        {
            return TWO;
        }
        else if (run==3)
        {
            return THREE;
        }
        else if (run==4)
        {
            return FOUR;
        }
        else if (run==5)
        {
            return FIVE;
        }
        else
        {
            return SIX;
        }

    }
}
