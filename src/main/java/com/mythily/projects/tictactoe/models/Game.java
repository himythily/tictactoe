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

    public void makeMove() {
        //check the next player
        Player currPlayer = players.get(nextPlayerIndex);

        Move move;
        //validate the move
        do{
            move = currPlayer.makeMove(board);
        }while(!isValidateMove(move));

        //update cell on the board
        Cell cellToUpdate = board.getGrid().get(move.getCell().getRow()).get(move.getCell().getCol());
        cellToUpdate.setCellState(CellState.FILLED);
        cellToUpdate.setSymbol(currPlayer.getSymbol());

        //Add move to moves history
        moves.add(move);

        //Check the winner or is draw
        if(checkWinner(move)){
            setGameState(GameState.SUCCESS);
            setWinner(currPlayer);
        }else if(moves.size() == board.getDimension() * board.getDimension()){
            setGameState(GameState.DRAW);
        }

        //Increment the next player index
        nextPlayerIndex++; //0, 1, 2, 0, 1, 2
        nextPlayerIndex = nextPlayerIndex % players.size();
        // (a + b) % n
    }

    private boolean checkWinner(Move move) {
        for(WinningStrategy strategy : winningStrategies){
            if(strategy.checkWinner(board, move)){
                return true;
            }
        }
        return false;
    }

    private boolean isValidateMove(Move move) {
        int r = move.getCell().getRow();
        int c = move.getCell().getCol();
        if( r < 0 || r >= board.getDimension() || c < 0 || c >= board.getDimension()){
            System.out.println("Invalid Move: Outside of the board");
            return false;
        }
        if(board.getGrid().get(r).get(c).getCellState().equals(CellState.FILLED)){
            System.out.println("Invalid Move: Cell is filled");
            return false;
        }

        return true;
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
