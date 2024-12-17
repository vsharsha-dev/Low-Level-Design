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