package com.mycompany.app.medium.pub_sub_system;

import com.mycompany.app.medium.pub_sub_system.User.Publisher;
import com.mycompany.app.medium.pub_sub_system.User.Subscriber;

public class Main {
    public static void main(String[] args) {
        PubSubSystem system = new PubSubSystem();

         // Create topics
        Topic topic1 = new Topic("1","Topic1");
        Topic topic2 = new Topic("2","Topic2");

        // Create publishers
        Publisher publisher1 = new Publisher("1", "Mohammed");
        Publisher publisher2 = new Publisher("2", "Khaled");

        // Create subscribers
        Subscriber subscriber1 = new Subscriber("1","Subscriber1");
        Subscriber subscriber2 = new Subscriber("2","Subscriber2");
        Subscriber subscriber3 = new Subscriber("3","Subscriber3");

        // Create messages
        Message message1 = new Message("1","Message1 for Topic1");
        Message message2 = new Message("2","Message2 for Topic1");
        Message message3 = new Message("3","Message1 for Topic2");
        Message message4 = new Message("4","Message3 for Topic1");
        Message message5 = new Message("5","Message2 for Topic2");

        // Add topics, publishers, subscribers and messages
        system.addTopic(topic1);
        system.addTopic(topic2);
        system.addPublisher(publisher1);
        system.addPublisher(publisher2);
        system.addSubscriber(subscriber1);
        system.addSubscriber(subscriber2);
        system.addSubscriber(subscriber3);

        // Subscribe to topics
        system.subscribeToTopic(subscriber1, topic1);
        system.subscribeToTopic(subscriber2, topic1);
        system.subscribeToTopic(subscriber2, topic2);
        system.subscribeToTopic(subscriber3, topic2);

        // Publish messages
        system.publishMessage(publisher1, message1, topic1);
        system.publishMessage(publisher1, message2, topic1);
        system.publishMessage(publisher2, message3, topic2);
        
        // Unsubscribe from a topic
        system.unsubscribeToTopic(subscriber2, topic1);
        
        // Publish more messages
        system.publishMessage(publisher1, message4, topic1);
        system.publishMessage(publisher1, message5, topic2);
    }
}
