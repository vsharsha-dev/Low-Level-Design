package LowLevelDesign.ATM.CashWithdrawalProcess;

import LowLevelDesign.ATM.AtmMachine;

public class TwoThousandWithdrawalProcessor extends CashWithdrawalProcessor{
    public TwoThousandWithdrawalProcessor(CashWithdrawalProcessor next){
        super(next);
    }
    
    public void withdraw(AtmMachine atm, int remainingAmount){
        int required = remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNumOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        }
        else if(required > atm.getNumOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNumOfTwoThousandNotes());
            balance = balance + (required-atm.getNumOfTwoThousandNotes()) * 2000;
        }

        if(balance != 0){
           super.withdraw(atm, balance);
        }

    }
}
