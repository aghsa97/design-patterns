package com.mycompany.app.medium.pub_sub_system.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.app.medium.pub_sub_system.Message;
import com.mycompany.app.medium.pub_sub_system.Topic;

public class Publisher extends User {
    private List<Message> messages;
    private Map<String, Topic> topics;

    public Publisher(String id, String name) {
        super(id, name);
        messages = new ArrayList<Message>();
        topics = new HashMap<String, Topic>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void publish(Message message, Topic topic) {
        messages.add(message);
        if (topics.get(message.getId()) != null) {
            System.out.println("This publisher can't publish to topic" + topic.getName());
            return;
        }
        topic.publish(message);
    }

    public Map<String, Topic> getTopics() {
        return topics;
    }
}
