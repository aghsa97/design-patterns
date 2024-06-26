package com.mycompany.app.medium.pub_sub_system;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.medium.pub_sub_system.User.Subscriber;

public class Topic {
    private String id;
    private String name;
    private Map<String, Subscriber> subscribers;

    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
        this.subscribers = new HashMap<String, Subscriber>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.put(subscriber.getId(), subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber.getId());
    }

    public void publish(Message message) {
        for (Subscriber subscriber : subscribers.values()) {
            subscriber.onMessage(message);
        }
    }
}
