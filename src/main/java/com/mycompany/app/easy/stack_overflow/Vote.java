package com.mycompany.app.easy.stack_overflow;

public class Vote {
    private final String id;
    private final String owner;
    
    public Vote(String id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

}
