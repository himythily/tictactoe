package com.mythily.projects.tictactoe.strategies;

import com.mythily.projects.tictactoe.models.Board;
import com.mythily.projects.tictactoe.models.Cell;

public interface BotPlayingStrategy {
    public Cell makeMove(Board board);
}