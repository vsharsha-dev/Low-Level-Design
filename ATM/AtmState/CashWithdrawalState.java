package LowLevelDesign.ATM.AtmState;

import LowLevelDesign.ATM.AtmMachine;
import LowLevelDesign.ATM.Card;
import LowLevelDesign.ATM.CashWithdrawalProcess.CashWithdrawalProcessor;
import LowLevelDesign.ATM.CashWithdrawalProcess.FiveHundredWithdrawalProcessor;
import LowLevelDesign.ATM.CashWithdrawalProcess.OneHundredWithdrawalProcessor;
import LowLevelDesign.ATM.CashWithdrawalProcess.TwoThousandWithdrawalProcessor;

public class CashWithdrawalState extends AtmState{
    public CashWithdrawalState(){
        System.out.println("Please enter amount to withdraw...");
    }

    @Override
    public void withdrawCash(AtmMachine atm, Card card, int amount){
        if(atm.getBalance() < amount){
            System.out.println("Insufficient balance in the ATM.");
            exit(atm);
        }
        else if(card.getUserBankAccount().getBalance() < amount){
            System.out.println("Insufficient balance in the bank account.");
            exit(atm);
        }
        else {
            card.getUserBankAccount().withdrawAmount(amount);
            atm.withdrawAmount(amount);

            CashWithdrawalProcessor withdrawalProcessor = 
                new TwoThousandWithdrawalProcessor(new FiveHundredWithdrawalProcessor(new OneHundredWithdrawalProcessor(null)));
            
            withdrawalProcessor.withdraw(atm, amount);
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
