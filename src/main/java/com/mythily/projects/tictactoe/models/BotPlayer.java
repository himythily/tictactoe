package com.mythily.projects.tictactoe.models;

import com.mythily.projects.tictactoe.factory.BotPlayingStrategyFactory;
import com.mythily.projects.tictactoe.strategies.BotPlayingStrategy;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;
    public BotPlayer(int id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        botPlayingStrategy = BotPlayingStrategyFactory.getStrategy(botDifficultyLevel);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        //make the move depending on difficulty level
        System.out.println("It's " + this.getName() + "'s turn. Calculating move ...");
        Cell cell = botPlayingStrategy.makeMove(board);
        if(cell != null){
            return new Move(cell, this);
        }
        return  null;
    }
}
