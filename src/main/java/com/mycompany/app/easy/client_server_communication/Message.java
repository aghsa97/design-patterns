package com.mycompany.app.easy.client_server_communication;

public class Message {
    /* 
     * The content of the message.
     
     */
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
