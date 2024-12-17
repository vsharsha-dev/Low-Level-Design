import java.util.Set;
import java.util.HashSet;

public class Publisher {
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