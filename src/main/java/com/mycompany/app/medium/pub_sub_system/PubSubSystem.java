package com.mycompany.app.medium.pub_sub_system;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.medium.pub_sub_system.User.Publisher;
import com.mycompany.app.medium.pub_sub_system.User.Subscriber;

public class PubSubSystem {
    private Map<String, Publisher> publishers;
    private Map<String, Subscriber> subscribers;
    private Map<String, Topic> topics;
    private Map<String, Message> messages;

    public PubSubSystem() {
        publishers = new HashMap<String, Publisher>();
        subscribers = new HashMap<String, Subscriber>();
        topics = new HashMap<String, Topic>();
        messages = new HashMap<String, Message>();
    }

    public Map<String, Publisher> getPublishers() {
        return publishers;
    }

    public Map<String, Subscriber> getSubscribers() {
        return subscribers;
    }
    
    public Map<String, Topic> getTopics() {
        return topics;
    }
    
    public void addPublisher(Publisher publisher) {
        publishers.put(publisher.getId(), publisher);
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.put(subscriber.getId(), subscriber);
    }
    
    public void addTopic(Topic topic) {
        topics.put(topic.getId(), topic);
    }

    private void addMessage(Message message) {
        messages.put(message.getId(), message);
    }

    public synchronized void publishMessage(Publisher publisher, Message message, Topic topic) {
        if (publishers.get(publisher.getId()) != null && topics.get(topic.getId()) != null) {
            publisher.publish(message, topic);
            addMessage(message);
        }
    }

    public synchronized void subscribeToTopic(Subscriber subscriber, Topic topic) {
        Topic currentTopic = topics.get(topic.getId());
        Subscriber currentSubscriber = subscribers.get(subscriber.getId());

        if (currentTopic != null && currentSubscriber != null) {
            currentTopic.addSubscriber(currentSubscriber);
            currentSubscriber.subscribe(currentTopic);
        }
    }

    public synchronized void unsubscribeToTopic(Subscriber subscriber, Topic topic) {
        Topic currentTopic = topics.get(topic.getId());
        Subscriber currentSubscriber = subscribers.get(subscriber.getId());

        if (currentTopic != null && currentSubscriber != null) {
            currentTopic.removeSubscriber(currentSubscriber);
            currentSubscriber.unsubscribe(currentTopic);
        }
    }

}
