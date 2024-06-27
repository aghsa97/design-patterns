package com.mycompany.app.easy.client_server_communication;

public class Message {
    private final String id;
    private String content;
    private int counter;

    public Message(String id, String content, int counter) {
        this.id = id;
        this.content = content;
        this.counter = counter;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getCounter() {
        return counter;
    }
    
    public void setCounter(int counter) {
        this.counter = counter;
    }
}
