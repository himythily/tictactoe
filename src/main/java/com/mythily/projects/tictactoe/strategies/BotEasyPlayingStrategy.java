package com.mythily.projects.tictactoe.strategies;

import com.mythily.projects.tictactoe.models.Board;
import com.mythily.projects.tictactoe.models.Cell;
import com.mythily.projects.tictactoe.models.CellState;

import java.util.List;

public class BotEasyPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Cell makeMove(Board board) {
        for(List<Cell> row: board.getGrid()){
            for(Cell cell: row)
            {
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Cell(cell.getRow(), cell.getCol());
                }
            }
        }
        return null;
    }
}