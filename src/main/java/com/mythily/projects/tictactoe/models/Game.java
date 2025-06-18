package com.mythily.projects.tictactoe.models;

import com.mythily.projects.tictactoe.strategies.WinningStrategy;
import com.mythily.projects.tictactoe.validations.DimensionAndPlayerValidation;
import com.mythily.projects.tictactoe.validations.UniqueSymbolValidation;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;
    private int nextPlayerIndex;
    private Player winner;
    List<Move> moves;

    private Game(Builder builder) {
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.winningStrategies = builder.winningStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void displayBoard() {
        board.display();
    }

    public static class Builder {
        private int dimension; // used to create board
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder() {
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setWinningStrategy(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Game build() {
            //validations

            //Dimension and Player check
            DimensionAndPlayerValidation.validate(dimension, players);
            //Symbol should be different
            //UniqueSymbolValidation.validateSymbol();

            //there can be only one bot per game

            return new Game(this);
        }

    }
}
