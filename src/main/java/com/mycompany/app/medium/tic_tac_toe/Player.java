package com.mycompany.app.medium.tic_tac_toe;

public class Player {
    private String id;
    private String role;

    public Player(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
