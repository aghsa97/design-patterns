package com.mycompany.app.easy.client_server_communication;

import java.util.concurrent.atomic.AtomicBoolean;

class Player implements Runnable {
    private String name;
    private int messageCounter;
    private boolean isInitiator;
    private static final int MAX_MESSAGES = 10;
    private static final AtomicBoolean player1Turn = new AtomicBoolean(true);

    public Player(String name, boolean isInitiator) {
        this.name = name;
        this.messageCounter = 0;
        this.isInitiator = isInitiator;
    }

    public synchronized void sendMessage(String content) {
        try {
            MessageQueue.getInstance().getQueue().put(new Message(content));
            System.out.println(name + " sent: " + content);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void receiveMessage() {
        try {
            Message message = MessageQueue.getInstance().getQueue().take();
            System.out.println(name + " received: " + message.getContent());
            if (messageCounter < MAX_MESSAGES) {
                messageCounter++;
                String responseContent = "hi from "+ name + " " + messageCounter;
                sendMessage(responseContent);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        if (isInitiator) {
            sendMessage("Hi from initiator!");
        }

        while (messageCounter < MAX_MESSAGES) {
            synchronized (player1Turn) {
                while ((isInitiator && !player1Turn.get()) || (!isInitiator && player1Turn.get())) {
                    try {
                        player1Turn.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                receiveMessage();
                player1Turn.set(!isInitiator);
                player1Turn.notifyAll();
            }
        }

        System.out.println(name + " finished.");
    }
}
