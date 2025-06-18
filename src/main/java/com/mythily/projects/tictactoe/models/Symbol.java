package com.mythily.projects.tictactoe.models;

import lombok.Data;

@Data
public class Symbol {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }
}
