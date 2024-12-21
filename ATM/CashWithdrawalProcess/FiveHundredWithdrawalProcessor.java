package LowLevelDesign.ATM.CashWithdrawalProcess;

import LowLevelDesign.ATM.AtmMachine;

public class FiveHundredWithdrawalProcessor extends CashWithdrawalProcessor{
    public FiveHundredWithdrawalProcessor(CashWithdrawalProcessor next){
        super(next);
    }
    
    public void withdraw(AtmMachine atm, int remainingAmount){
        int required = remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNumOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        }
        else if(required > atm.getNumOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getNumOfFiveHundredNotes());
            balance = balance + (required-atm.getNumOfFiveHundredNotes()) * 500;
        }

        if(balance != 0){
           super.withdraw(atm, balance);
        }

    }
    
}
