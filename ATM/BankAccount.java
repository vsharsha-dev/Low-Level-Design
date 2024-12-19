package ATM;

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
}
