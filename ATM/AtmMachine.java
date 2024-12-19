package ATM;

import ATM.AtmState.AtmState;

public class AtmMachine {
    int balanceAmount;
    int numOfTwoThousandNotes;
    int numOfFiveHundredNotes;
    int numOfOneHundredNotes;
    AtmState atmState;

    public AtmMachine(int balance, int twoThousand, int fiveHundred, int oneHundred){
        balanceAmount = balance;
        numOfTwoThousandNotes = twoThousand;
        numOfFiveHundredNotes = fiveHundred;
        numOfOneHundredNotes = oneHundred;
    }

    public int getBalance() {
        return balanceAmount;
    }

    public void setAtmState(AtmState state){
        atmState = state;
    }

    public AtmState getAtmState() {
        return atmState;
    }
}
