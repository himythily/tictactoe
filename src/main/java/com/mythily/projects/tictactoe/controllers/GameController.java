package com.mythily.projects.tictactoe.controllers;

import com.mythily.projects.tictactoe.models.Game;
import com.mythily.projects.tictactoe.models.GameState;
import com.mythily.projects.tictactoe.models.Player;
import com.mythily.projects.tictactoe.strategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> strategies) {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(strategies)
                .build();
    }
    public GameState checkGameState(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
    public void undo(Game game){

    }
    public void display(Game game){
        game.displayBoard();
    }
}
