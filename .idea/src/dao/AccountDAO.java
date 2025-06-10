package dao;

import model.*;
import io.FileHandler;

import java.io.IOException;
import java.util.*;

public class AccountDAO {
    private FileHandler fileHandler = new FileHandler();
    private List<Account> accounts = new ArrayList<>();

    public AccountDAO() {
        loadAccounts();
    }

    private void loadAccounts() {
        try {
            List<String> lines = fileHandler.readLines();
            accounts.clear();
            for (String line : lines) {
                String[] parts = line.split(",");
                if(parts.length < 3) continue;
                int id = Integer.parseInt(parts[0]);
                String type = parts[1];
                double balance = Double.parseDouble(parts[2]);

                if ("Savings".equalsIgnoreCase(type)) {
                    accounts.add(new SavingsAccount(id, balance));
                } else if ("Current".equalsIgnoreCase(type)) {
                    accounts.add(new CurrentAccount(id, balance));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }

    private void saveAccounts() {
        try {
            List<String> lines = new ArrayList<>();
            for (Account acc : accounts) {
                lines.add(acc.toString());
            }
            fileHandler.writeLines(lines);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    public Account getAccountById(int accountId) {
        for(Account acc : accounts) {
            if(acc.getAccountId() == accountId)
                return acc;
        }
        return null;
    }

    public boolean addAccount(Account account) {
        if(getAccountById(account.getAccountId()) != null)
            return false; // ID already exists

        accounts.add(account);
        saveAccounts();
        return true;
    }

    public boolean updateAccount(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountId() == account.getAccountId()) {
                accounts.set(i, account);
                saveAccounts();
                return true;
            }
        }
        return false;
    }

    // Generates a new unique account ID
    public int generateNewAccountId() {
        int maxId = 0;
        for(Account acc : accounts) {
            if(acc.getAccountId() > maxId)
                maxId = acc.getAccountId();
        }
        return maxId + 1;
    }
}
