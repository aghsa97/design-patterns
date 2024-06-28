package com.mycompany.app.easy.client_server_communication;

import java.io.*;
import java.net.*;

public class PlayerClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;
        int initiatorSentMessages = 1;
        int initiatorReceivedMessages = 0;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Initiator sends the first message
            out.println("Message 1");

            while (initiatorSentMessages < 10 || initiatorReceivedMessages < 10) {
                String receivedMessage = in.readLine();
                if (receivedMessage == null) break;
                System.out.println("Client received: " + receivedMessage);
                initiatorReceivedMessages++;
                if (initiatorSentMessages < 10) {
                    out.println("Message " + (initiatorSentMessages + 1));
                    initiatorSentMessages++;
                }
            }

            System.out.println("Communication finished.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

