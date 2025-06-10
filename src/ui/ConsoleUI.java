package ui;

import dao.AccountDAO;
import model.*;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);
    private AccountDAO accountDAO = new AccountDAO();

    public void start() {
        System.out.println("===== Welcome to the Banking System =====");

        while(true) {
            printMenu();
            int choice = getIntInput("Enter your choice:");

            switch(choice) {
                case 1: createAccount(); break;
                case 2: depositMoney(); break;
                case 3: withdrawMoney(); break;
                case 4: checkBalance(); break;
                case 5: System.out.println("Exiting... Thank you!"); return;
                default: System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
    }

    private void createAccount() {
        System.out.println("\nChoose account type:");
        System.out.println("1. Savings (Minimum balance 500)");
        System.out.println("2. Current (Overdraft limit -1000)");
        int typeChoice = getIntInput("Enter choice:");

        int newId = accountDAO.generateNewAccountId();
        Account newAccount = null;

        switch(typeChoice) {
            case 1:
                newAccount = new SavingsAccount(newId, 500);
                break;
            case 2:
                newAccount = new CurrentAccount(newId, 0);
                break;
            default:
                System.out.println("Invalid account type selected.");
                return;
        }

        if(accountDAO.addAccount(newAccount)) {
            System.out.println("Account created successfully! Account ID: " + newId);
        } else {
            System.out.println("Failed to create account.");
        }
    }

    private void depositMoney() {
        int id = getIntInput("Enter Account ID:");
        Account acc = accountDAO.getAccountById(id);
        if(acc == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = getDoubleInput("Enter amount to deposit:");
        if(amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        acc.deposit(amount);
        if(accountDAO.updateAccount(acc)) {
            System.out.println("Deposit successful. New balance: " + acc.getBalance());
        } else {
            System.out.println("Failed to update account.");
        }
    }

    private void withdrawMoney() {
        int id = getIntInput("Enter Account ID:");
        Account acc = accountDAO.getAccountById(id);
        if(acc == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = getDoubleInput("Enter amount to withdraw:");
        if(amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if(acc.withdraw(amount)) {
            if(accountDAO.updateAccount(acc)) {
                System.out.println("Withdrawal successful. New balance: " + acc.getBalance());
            } else {
                System.out.println("Failed to update account.");
            }
        } else {
            System.out.println("Withdrawal failed: insufficient funds or balance constraints.");
        }
    }

    private void checkBalance() {
        int id = getIntInput("Enter Account ID:");
        Account acc = accountDAO.getAccountById(id);
        if(acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Account Type: " + acc.getAccountType());
        System.out.println("Current Balance: " + acc.getBalance());
    }

    // Helper method to get integer input with validation
    private int getIntInput(String prompt) {
        while(true) {
            System.out.print(prompt + " ");
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    // Helper method to get double input with validation
    private double getDoubleInput(String prompt) {
        while(true) {
            System.out.print(prompt + " ");
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input.trim());
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
