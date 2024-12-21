package LowLevelDesign.ATM;

//import ATM.AtmState.*;
import LowLevelDesign.ATM.AtmState.AtmState;
import LowLevelDesign.ATM.AtmState.IdleState;
// import ATM.AtmState.IdleState;

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
        atmState = new IdleState();
    }

    public int getBalance() {
        return balanceAmount;
    }

    public void setBalance(int newBalance){
        balanceAmount = newBalance;
    }

    public void withdrawAmount(int amount){
        setBalance(balanceAmount - amount);
    }

    public void setAtmState(AtmState state){
        atmState = state;
    }

    public AtmState getAtmState() {
        return atmState;
    }

    public int getNumOfTwoThousandNotes() {
        return numOfTwoThousandNotes;
    }
    public void deductTwoThousandNotes(int num) {
        numOfTwoThousandNotes -= num;
    }
    public int getNumOfFiveHundredNotes() {
        return numOfFiveHundredNotes;
    }
    public void deductFiveHundredNotes(int num) {
        numOfFiveHundredNotes -= num;
    }
    public int getNumOfOneHundredNotes() {
        return numOfOneHundredNotes;
    }
    public void deductOneHundredNotes(int num) {
        numOfOneHundredNotes -= num;
    }
    
}
