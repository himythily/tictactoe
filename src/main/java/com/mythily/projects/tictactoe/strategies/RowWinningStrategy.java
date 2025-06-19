package com.mythily.projects.tictactoe.strategies;

import com.mythily.projects.tictactoe.models.Board;
import com.mythily.projects.tictactoe.models.Move;
import com.mythily.projects.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    Map<Integer, Map<Symbol,Integer>> count = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        count.putIfAbsent(move.getCell().getRow(), new HashMap<>());
        Map<Symbol,Integer> rowCount = count.get(move.getCell().getRow());

        Symbol symbol = move.getPlayer().getSymbol();
        rowCount.putIfAbsent(symbol, 0);
        rowCount.put(symbol, rowCount.get(symbol) + 1);

        if(rowCount.get(symbol) == board.getDimension()){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Move move) {
        Map<Symbol,Integer> rowCount = count.get(move.getCell().getRow());
        Symbol symbol = move.getPlayer().getSymbol();
        rowCount.put(symbol, rowCount.get(symbol) - 1);
    }
}
