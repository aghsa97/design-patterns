package com.mycompany.app.medium.pub_sub_system.User;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.medium.pub_sub_system.Message;
import com.mycompany.app.medium.pub_sub_system.Topic;

public class Subscriber extends User {
    private List<Topic> subs;

    public Subscriber(String id, String name) {
        super(id, name);
        this.subs = new ArrayList<Topic>();
    }

    public List<Topic> getSubs() {
        return subs;
    }

    public void subscribe(Topic topic) {
        this.subs.add(topic);
    }

    public void unsubscribe(Topic topic) {
        if (subs.contains(topic)) {
            this.subs.remove(topic);
        }
    }

    public void onMessage(Message message) {
        System.out.println("Subscriber " + getName() + " received message: " + message.getContent());
    }
}
