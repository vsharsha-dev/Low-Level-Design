package LowLevelDesign.ATM.AtmState;

import LowLevelDesign.ATM.AtmMachine;
import LowLevelDesign.ATM.Card;

public class IdleState extends AtmState{
    @Override
    public void insertCard(AtmMachine atm, Card card){
        System.out.println("Card inserted in the ATM.");
        atm.setAtmState(new HasCardState());
    }
}
