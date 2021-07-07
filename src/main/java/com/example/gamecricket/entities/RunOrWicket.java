package com.example.gamecricket.entities;

public enum RunOrWicket {
    DOT_BALL("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    WICKET("W");
    private final String label;

    RunOrWicket(String label) {

        this.label=label;
    }
}
