package com.mythily.projects.tictactoe.models;

import lombok.Data;

@Data
public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Symbol symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
        this.symbol = null;
    }
    
    public void display() {
        if(cellState.equals(CellState.EMPTY)){
            System.out.print("| - |");
        }else if(cellState.equals(CellState.FILLED)){
            System.out.print("| "+ symbol.getSymbol() +" |");
        }
    }
}
