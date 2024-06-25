package com.mycompany.app.medium.tic_tac_toe;

public class Player {
    private String id;
    private String name;
    private char role;

    public Player(String id, char role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public char getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}
