package com.mythily.projects.tictactoe.models;

public class Move {
    private Cell cell;
    private Player player;
    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }
}
