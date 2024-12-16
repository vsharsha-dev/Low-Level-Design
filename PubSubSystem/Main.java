// package PubSubSystem;

import java.util.Set;
import java.util.*;

class Publisher {
    String name;
    Set<Topic> topics;

    public Publisher(String pubName){
        name = pubName;
        topics = new HashSet<Topic>();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void publish(Message message){
        for(Topic topic : topics){
            System.out.println("Publisher " + name + " sent a message to topic " + topic.getName());
            topic.publish(message);
        }
    }
}

class Subscriber {
    String name;

    public Subscriber(String subName){
        this.name = subName;
    }

    public void sendMessage(Message msg){
        System.out.println("Message received by subscriber " + name + " : " + msg.getContent());
    }

    public void subscribeTo(Topic topic){
        topic.addSubscriber(this);
    }
}

class Topic {
    String name;
    Set<Subscriber> subscribers;

    public Topic(String topicName){
        name = topicName;
        subscribers = new HashSet<Subscriber>();
    }

    public String getName(){
        return this.name;
    }
    public void addSubscriber(Subscriber sub){
        subscribers.add(sub);
    }

    public void removeSubscriber(Subscriber sub){
        subscribers.remove(sub);
    }

    public void publish(Message msg){
        for(Subscriber sub : subscribers){
            sub.sendMessage(msg);
        }
    }
}

class Message {
    String content;

    public Message(String messageContent){
        content = messageContent;
    }

    public String getContent() {
        return this.content;
    }
}

public class Main {
    public static void main(String[] args) {
        Publisher p1 = new Publisher("Pub1");
        Publisher p2 = new Publisher("Pub2");
        Publisher p3 = new Publisher("Pub3");

        Topic t1 = new Topic("Topic1");
        Topic t2 = new Topic("Topic2");

        Subscriber s1 = new Subscriber("Sub1");
        Subscriber s2 = new Subscriber("Sub2");
        Subscriber s3 = new Subscriber("Sub3");

        p1.addTopic(t1);
        p2.addTopic(t1);
        p3.addTopic(t2);

        s1.subscribeTo(t1);
        s1.subscribeTo(t2);
        s2.subscribeTo(t1);
        s2.subscribeTo(t2);
        s3.subscribeTo(t2);

        p1.publish(new Message("Message1"));
        p2.publish(new Message("Message2"));
        p3.publish(new Message("Message3"));
    }
}