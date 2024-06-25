package com.mycompany.app.medium.tic_tac_toe;

public class Main {
    public static void main (String[] args) {
        System.out.println("Hello, World!");
        Player x = new Player("1", 'X', "mou");
        Player o = new Player("2", 'O', "aws");
        Game game = new Game(x,o);
        game.start();
    }
}
