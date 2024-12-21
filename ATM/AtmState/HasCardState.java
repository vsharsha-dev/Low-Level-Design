package LowLevelDesign.ATM.AtmState;

import LowLevelDesign.ATM.AtmMachine;
import LowLevelDesign.ATM.Card;

public class HasCardState extends AtmState {
    @Override
    public void authenticateCard(AtmMachine atm, Card card, String pin){
        if(Integer.valueOf(pin).equals(Integer.valueOf(card.getAtmPin()))){
            System.out.println("Authenticating...");
            atm.setAtmState(new SelectOperationState());
        }
        else {
            System.out.println("Incorrect Pin.");
            exit(atm);
        }
    }

    @Override
    public void exit(AtmMachine atm){
        System.out.println("Please collect your card.");
        atm.setAtmState(new IdleState());
        System.out.println("Exitted");
    }
}
