package com.mycompany.app.easy.client_server_communication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageQueue {
    /*
     * The MessageQueue class is a singleton class that holds a blocking queue of messages.
     * It is used to pass messages between the initiator and the receiver.
     
     */
    private static MessageQueue instance;
    private final BlockingQueue<Message> queue;

    private MessageQueue() {
        queue = new LinkedBlockingDeque<Message>();
    }

    public synchronized static MessageQueue getInstance() {
        if (instance == null) {
            instance = new MessageQueue();
        }
        return instance;
    }

    public BlockingQueue<Message> getQueue() {
        return queue;
    }
}
