package LowLevelDesign.ATM.AtmState;

import LowLevelDesign.ATM.AtmMachine;
import LowLevelDesign.ATM.Card;
import LowLevelDesign.ATM.OperationType;

public abstract class AtmState {
    public void insertCard(AtmMachine atm, Card card){
        System.out.println("Could not insert card. ATM not in correct state.");
    }
    public void authenticateCard(AtmMachine atm, Card card, String pin){
        System.out.println("Could not authenticate card. ATM not in correct state.");
    }
    public void selectOperation(AtmMachine atm, Card card, OperationType operation) {
        System.out.println("Could not select operation. ATM not in correct state.");
    }
    public void getBalance(AtmMachine atm, Card card){
        System.out.println("Could not get balance. ATM not in correct state.");
    }
    public void withdrawCash(AtmMachine atm, Card card, int amount){
        System.out.println("Could not withdraw the amount. ATM not in correct state.");
    }
    public void removeCard(){
        System.out.println("Could not remove card. ATM not in correct state.");
    }
    public void exit(AtmMachine atm){
        System.out.println("Could not exit. ATM not in correct state.");
    }
}
