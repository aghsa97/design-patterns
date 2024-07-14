package com.mycompany.app.hard.ride_sharing_service;

public class User {
    private final String id;
    private String location;
    private double wallet;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.wallet = 100;
        this.location = "Düsseldorf";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWallet() {
        return wallet;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
