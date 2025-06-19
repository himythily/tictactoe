package com.mythily.projects.tictactoe.models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(int id, String name, Symbol symbol) {
        super(id, name, symbol, PlayerType.HUMAN);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("It is "+ getName() +"'s turn. ");
        System.out.print("Enter row: ");
        int row = scanner.nextInt();
        System.out.print("Enter column: ");
        int column = scanner.nextInt();

        Cell cell = new Cell(row, column);
        return new Move(cell, this);
    }
}
