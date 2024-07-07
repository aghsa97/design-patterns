package com.mycompany.app.easy.stack_overflow;

public class User {
    private final String id;
    private final String username;
    private final String password;
    private boolean isLoggedin;
    private int reputation;

    public User(String id, String username, String password, int reputation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isLoggedin = false;
        this.reputation = reputation;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getReputation() {
        return reputation;
    }
    
    public boolean isLoggedin() {
        return isLoggedin;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }
}
