package LowLevelDesign.ATM.CashWithdrawalProcess;

import LowLevelDesign.ATM.AtmMachine;

public abstract class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    public CashWithdrawalProcessor(CashWithdrawalProcessor next){
        this.nextCashWithdrawalProcessor = next;
    }

    public void withdraw(AtmMachine atm, int remainingAmount){
        if(nextCashWithdrawalProcessor != null){
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}
