package com.mycompany.app.medium.tic_tac_toe;

public class Board {
    private final char[][] grid;

    public Board() {
        grid = new char[3][3];
        initializeBoard();
    }

    public char[][] getGrid() {
        return grid;
    }

     private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = '-';
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
