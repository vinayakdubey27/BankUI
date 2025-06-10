package model;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = -1000;

    public CurrentAccount(int accountId, double initialBalance) {
        super(accountId, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && (balance - amount) >= OVERDRAFT_LIMIT) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}
