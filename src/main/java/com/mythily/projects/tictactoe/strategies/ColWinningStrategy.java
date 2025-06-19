package com.mythily.projects.tictactoe.strategies;

import com.mythily.projects.tictactoe.models.Board;
import com.mythily.projects.tictactoe.models.Move;
import com.mythily.projects.tictactoe.models.Player;
import com.mythily.projects.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy {
    Map<Integer, Map<Symbol,Integer>> count = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        count.putIfAbsent(move.getCell().getCol(), new HashMap<>());
        Map<Symbol,Integer> colCount = count.get(move.getCell().getCol());

        Symbol symbol = move.getPlayer().getSymbol();
        colCount.putIfAbsent(symbol, 0);
        colCount.put(symbol, colCount.get(symbol) + 1);

        if(colCount.get(symbol) == board.getDimension()){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Move move) {
        Map<Symbol,Integer> colCount = count.get(move.getCell().getRow());
        Symbol symbol = move.getPlayer().getSymbol();
        colCount.put(symbol, colCount.get(symbol) - 1);
    }
}
