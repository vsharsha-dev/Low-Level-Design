package LowLevelDesign.ATM.AtmState;

import LowLevelDesign.ATM.AtmMachine;
import LowLevelDesign.ATM.Card;

public class CheckBalanceState extends AtmState{
    @Override
    public void getBalance(AtmMachine atm, Card card) {
        System.out.println("Your current balance is: " + card.getUserBankAccount().getBalance());
        exit(atm);
    }

    @Override
    public void exit(AtmMachine atm){
        System.out.println("Please collect your card.");
        atm.setAtmState(new IdleState());
        System.out.println("Exitted");
    }
}
