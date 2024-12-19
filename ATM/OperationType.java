package ATM;

public enum OperationType {
    CASH_WITHDRAWAL,
    CHECK_BALANCE;

    public static void getAllOperationTypes() {
        for(OperationType operation : OperationType.values()){
            System.out.println(operation.name());
        }
    }
}
