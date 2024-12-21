package LowLevelDesign.ATM;

public class User {
    String name;
    BankAccount account;

    public User(String uName, BankAccount acc){
        name = uName;
        account = acc;
    }

    public String getName() {
        return name;
    }
    public BankAccount getBankAccount(){
        return account;
    }
}
