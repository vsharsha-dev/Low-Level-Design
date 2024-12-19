package ATM.AtmState;

import ATM.AtmMachine;
import ATM.Card;
import ATM.OperationType;

public class SelectOperationState extends AtmState {
    public SelectOperationState() {
        System.out.println("Please select an operation...");
        OperationType.getAllOperationTypes();
    }

    @Override
    public void selectOperation(AtmMachine atm, Card card, OperationType operation){
        switch (operation) {
            case CASH_WITHDRAWAL:
                atm.setAtmState(new CashWithdrawalState());
                break;
            case CHECK_BALANCE:
                atm.setAtmState(new CheckBalanceState());
                break;
            default:
                System.out.println("Invalid operation. Please retry.");
                exit(atm);
                break;
        }
    }

    @Override
    public void exit(AtmMachine atm){
        System.out.println("Please collect your card.");
        atm.setAtmState(new IdleState());
        System.out.println("Exitted.");
    }


}
