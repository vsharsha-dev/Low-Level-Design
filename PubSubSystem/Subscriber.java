public class Subscriber {
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
