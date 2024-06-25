package com.mycompany.app.medium.tic_tac_toe;

public class Board {
    private final char[][] grid;
    private int moves;

    public Board(int size) {
        grid = new char[size][size];
        initializeBoard();
    }

    public int getMoves() {
        return moves;
    }

    public char[][] getGrid() {
        return grid;
    }

     private void initializeBoard() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = '-';
            }
        }
        moves = 0;
    }

    public void printBoard() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void makeMove(int row, int col, char move) {
        if (grid[row][col] != '-') {
            throw new IllegalArgumentException("Already Taken.");
        }
        moves++;
        grid[row][col] = move;
    }

    public boolean hasWinner() {
        for (int row = 0; row < grid.length; row++) {
            if (horizontalCheck(grid[row])) {
                return true;
            }
            for (int col = 0; col < grid[row].length; col++) {
                if (verticalCheck(col)) {
                    return true;
                }
            }
        }
        return diagonalCheckLeft() || diagonalCheckRight() || false;
    }

    private boolean diagonalCheckRight() {
        int col = 0;
        for (int row = 0; row < grid.length - 1; row++) {
            if (grid[row][col] != grid[row + 1][col + 1] || grid[row][col] == '-') {
                return false;
            }
            col++;
        }
        return true;
    }

    private boolean diagonalCheckLeft() {
        int col = 0;
        for (int row = grid.length - 1; row > 0; row--) {
            if (grid[row][col] != grid[row - 1][col + 1] || grid[row][col] == '-') {
                return false;
            }
            col++;
        }
        return true;
    }
    
    private boolean horizontalCheck(char[] row) {
        for (int col = 0; col < row.length - 1; col++) {
            if (row[col] != row[col + 1] || row[col] == '-') {
                return false;
            } 
        }
        return true;
    }

    private boolean verticalCheck(int col) {
        for (int row = 0; row < grid.length - 1; row++) {
            if (grid[row][col] != grid[row + 1][col] || grid[row][col] == '-') {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        return moves == grid.length * grid.length;
    }
    
}
