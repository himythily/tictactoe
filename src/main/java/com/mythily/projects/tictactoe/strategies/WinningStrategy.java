package com.mythily.projects.tictactoe.strategies;

import com.mythily.projects.tictactoe.models.Board;
import com.mythily.projects.tictactoe.models.Move;
import com.mythily.projects.tictactoe.models.Player;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);
}
