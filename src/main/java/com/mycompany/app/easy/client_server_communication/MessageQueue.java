package com.mycompany.app.easy.client_server_communication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageQueue {
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
