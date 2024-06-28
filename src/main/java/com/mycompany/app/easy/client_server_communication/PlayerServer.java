package com.mycompany.app.easy.client_server_communication;

import java.io.*;
import java.net.*;

public class PlayerServer {
    public static void main(String[] args) {
        int port = 12345;
        int messageCounter = 0;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            while (true) {
                String receivedMessage = in.readLine();
                if (receivedMessage == null) break;
                System.out.println("Server received: " + receivedMessage);
                messageCounter++;
                String response = receivedMessage + " " + messageCounter;
                out.println(response);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

