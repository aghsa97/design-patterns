package com.mycompany.app.easy.client_server_communication;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("initiator", true);
        Player player2 = new Player("receiver", false);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Communication finished.");
    }
}
