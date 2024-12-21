package LowLevelDesign.ATM;

import LowLevelDesign.ATM.AtmState.IdleState;
import static LowLevelDesign.ATM.OperationType.CASH_WITHDRAWAL;
import static LowLevelDesign.ATM.OperationType.CHECK_BALANCE;


public class Main {
    public static void main(String[] args) {
        // Possible components: User, BankAccount, Card, AtmMachine
        BankAccount b1 = new BankAccount("12345", 3000);
        User u1 = new User("User 1", b1);

        Card c1 = new Card("324656473", "1234", u1);

        AtmMachine atm1 = new AtmMachine(5900, 2, 3, 4);

        System.out.println("Initi");

        atm1.setAtmState(new IdleState());

        atm1.getAtmState().insertCard(atm1, c1);
        atm1.getAtmState().authenticateCard(atm1, c1, "1234");
        atm1.getAtmState().selectOperation(atm1, c1, CASH_WITHDRAWAL);
        atm1.getAtmState().withdrawCash(atm1, c1, 2700);
//        atm1.getAtmState().selectOperation();
        atm1.getAtmState().insertCard(atm1, c1);
        atm1.getAtmState().authenticateCard(atm1, c1, "1234");
        atm1.getAtmState().selectOperation(atm1, c1, CHECK_BALANCE);
        atm1.getAtmState().getBalance(atm1, c1);
        atm1.getAtmState().exit(atm1);
    }
}
