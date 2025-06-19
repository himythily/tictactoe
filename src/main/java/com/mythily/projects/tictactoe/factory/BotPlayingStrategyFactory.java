package com.mythily.projects.tictactoe.factory;

import com.mythily.projects.tictactoe.models.BotDifficultyLevel;
import com.mythily.projects.tictactoe.strategies.BotEasyPlayingStrategy;
import com.mythily.projects.tictactoe.strategies.BotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getStrategy(BotDifficultyLevel difficultyLevel){
        return new BotEasyPlayingStrategy();
    }
}