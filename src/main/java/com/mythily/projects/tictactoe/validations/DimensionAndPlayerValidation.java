package com.mythily.projects.tictactoe.validations;

import com.mythily.projects.tictactoe.models.Player;

import java.util.List;

public class DimensionAndPlayerValidation {
    public static void validate(int dimension, List<Player> players) {

        if(players.size() < 1 || ((dimension -1) > players.size())) {
            throw new RuntimeException("Players and dimension are not valid");
        }

    }
}
