package com.mythily.projects.tictactoe.models;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    public BotPlayer(int id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
