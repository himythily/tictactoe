package com.mythily.projects.tictactoe.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Board {
    private int dimension;
    private List<List<Cell>> grid;
    public Board(int dimension) {
        this.dimension = dimension;
        //create grid
        grid=new ArrayList<>();
        for(int i=0;i<dimension;i++){
            grid.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public void display() {
        for(List<Cell> row:grid){
            System.out.println();
            for(Cell cell:row){
                cell.display();
            }
        }
    }
}
