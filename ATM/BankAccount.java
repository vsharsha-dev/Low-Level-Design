package LowLevelDesign.ATM;

public class BankAccount {
    String accountNumber;
    int accountBalance;

    public BankAccount(String accNo, int initialBalance){
        accountNumber = accNo;
        accountBalance = initialBalance;
    }

    public void withdrawMoney(int amount) {
        accountBalance -= amount;
        System.out.println("Balance in the Bank Account is Rs."+accountBalance);
    }

    public int getBalance() {
        return accountBalance;
    }

    public void setBalance(int amount) {
        accountBalance = amount;
    }

    public void withdrawAmount(int amount){
        setBalance(accountBalance - amount);
    }
}
