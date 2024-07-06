package com.mycompany.app.easy.stack_overflow.comments;

public class Comment {
    private final String id;
    private final String owner;
    private final String body;

    public Comment(String id, String comment, String owner) {
        this.id = id;
        this.body = comment;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getOwner() {
        return owner;
    }
}
