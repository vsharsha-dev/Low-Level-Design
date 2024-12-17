import java.util.Set;
import java.util.HashSet;

public class Topic {
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

