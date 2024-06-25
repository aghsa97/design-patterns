package com.mycompany.app.medium.tic_tac_toe;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currPlayer;
    private Scanner scanner;

    public Game(Player playerX, Player playerO) {
        this.board = new Board(3);
        this.playerX = playerX;
        this.playerO = playerO;
        this.currPlayer = playerX;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        try {
            board.printBoard();

            while(!board.isFull() && !board.hasWinner()) {
                System.out.println(currPlayer.getName() + "'s turn.");
                int row = getValidInput("Enter row (0-2): ");
                int col = getValidInput("Enter column (0-2): ");

                try {
                    board.makeMove(row, col, currPlayer.getRole());
                    board.printBoard();
                    switchPlayer();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (board.hasWinner()) {
                switchPlayer();
                System.out.println(currPlayer.getName() +" WINS!");
            } else {
                System.out.println("It's a draw!");
            }
            board.printBoard();
        } finally {
            scanner.close();
        }
    }

    public void switchPlayer() {
        currPlayer = (currPlayer == playerO) ? playerX : playerO;
    }

    private int getValidInput(String message) {
        int input;

        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }
}
