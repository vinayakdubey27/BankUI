package model;

public abstract class Account {
    protected int accountId;
    protected double balance;

    public Account(int accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    // Withdraw returns true if successful, false otherwise
    public abstract boolean withdraw(double amount);

    public abstract String getAccountType();

    @Override
    public String toString() {
        return accountId + "," + getAccountType() + "," + balance;
    }
}
