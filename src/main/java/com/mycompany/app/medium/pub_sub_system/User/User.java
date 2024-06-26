package com.mycompany.app.medium.pub_sub_system.User;

public abstract class User {
    private String id;
    private String name;


    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
