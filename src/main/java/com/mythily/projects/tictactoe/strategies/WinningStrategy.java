package com.mythily.projects.tictactoe.strategies;

import com.mythily.projects.tictactoe.models.Player;

public interface WinningStrategy {
    Player checkWinner();
}
