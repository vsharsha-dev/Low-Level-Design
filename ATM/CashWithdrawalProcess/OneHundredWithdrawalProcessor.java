package LowLevelDesign.ATM.CashWithdrawalProcess;

import LowLevelDesign.ATM.AtmMachine;

public class OneHundredWithdrawalProcessor extends CashWithdrawalProcessor{
    public OneHundredWithdrawalProcessor(CashWithdrawalProcessor next){
        super(next);
    }

    public void withdraw(AtmMachine atm, int remainingAmount){
        int required = remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNumOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        }
        else if(required > atm.getNumOfOneHundredNotes()) {
            atm.deductOneHundredNotes(atm.getNumOfOneHundredNotes());
            balance = balance + (required-atm.getNumOfOneHundredNotes()) * 500;
        }

        if(balance != 0){
           System.out.println("Could not withdraw the amount.");
        }
    }
}
