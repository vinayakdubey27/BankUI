package model;

public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(int accountId, double initialBalance) {
        super(accountId, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
