Basic Banking System

Team Details





Members:





Vinayak Dubey (24scse1410141)



Harsh Dedha (24scse1410342)



Pranav (24scse1410192)



Harshit Mehta (24scse1410120)



Program: BTech CSAI, 1st Year, 2nd Sem



Date: May 27, 2025

Project Overview

The Basic Banking System is a Java-based application with a graphical user interface (GUI) designed to manage bank accounts. It supports two types of accounts—Savings and Current—with distinct rules for deposits and withdrawals. The system ensures proper validation and error handling for user interactions.

# Java Banking System (Console-Based)

## Overview
This is a simple Java-based banking system implemented as a console application. It supports **Savings** and **Current** accounts with distinct rules and provides core banking features like creating accounts, depositing money, withdrawing money, and checking balances. Account data is persistently stored in a file.

---

## Features

- Create Savings and Current accounts  
- Deposit money into accounts  
- Withdraw money with balance constraints:
  - Savings accounts require a minimum balance of 500  
  - Current accounts allow overdraft up to -1000  
- Check account balances  
- File-based data persistence (`data/accounts.txt`)  
- Robust input validation and error handling  
- Modular code with Model, DAO, IO, and UI layers

---

## Project Structure

banking-system/
├── src/
│ ├── dao/ # Data Access Object classes
│ ├── io/ # File handling classes
│ ├── model/ # Account model classes
│ ├── ui/ # Console user interface classes
│ └── Main.java # Application entry point
├── data/
│ └── accounts.txt # Persistent storage file (auto-created)
└── README.md

yaml
Copy
Edit

---

## Prerequisites

- Java Development Kit (JDK) 11 or higher installed  
- Command line or IDE (e.g., IntelliJ IDEA, Eclipse) configured for Java development

---

## Setup & Running

1. **Compile** all Java source files, preserving the package structure:
   ```bash
   javac -d out src/model/*.java src/io/*.java src/dao/*.java src/ui/*.java src/Main.java
Run the application:

bash
Copy
Edit
java -cp out Main
Follow on-screen prompts to use the banking system features.

Usage
Upon start, you will see a menu with options:

Create Account

Deposit Money

Withdraw Money

Check Balance

Exit

Input the number corresponding to the action you want to perform.

When creating an account, choose between Savings or Current account.

Deposits and withdrawals require valid amounts and account IDs.

The program validates input and displays errors for invalid entries.

Account IDs are auto-generated and shown after account creation.

Design Notes
Model Layer: Defines Account abstract class and concrete subclasses SavingsAccount and CurrentAccount implementing specific withdrawal rules.

DAO Layer: Handles account data loading/saving using file I/O via FileHandler.

UI Layer: Console-based interaction handled by ConsoleUI, managing menus and user input validation.

Persistence: Accounts are saved in CSV format (accountId,accountType,balance) in data/accounts.txt.

Error Handling
Input parsing errors (e.g., non-numeric input) prompt re-entry.

Withdrawal checks prevent violating minimum balance or overdraft limits.

File read/write errors are caught and reported without crashing the application.

Possible Future Improvements
Add transaction history and statements.

Implement login authentication for accounts.

Switch to GUI-based interface using Swing or JavaFX.

Add interest calculation for Savings accounts.

Encrypt stored account data for security.



Interact with the GUI:





Enter an account number (e.g., "12345" for a Savings Account, "67890" for a Current Account).



Enter an amount for deposit or withdrawal.



Click the "Deposit," "Withdraw," or "Check Balance" buttons to perform actions.



Example Interactions:





Deposit $500 to account "12345": Shows "Deposit successful."



Withdraw $2000 from account "12345": Shows "Insufficient balance or invalid withdrawal."



Check balance of account "67890": Shows "Current Balance: $2000."

Screenshots

[Add a screenshot of the GUI here, showing the interface with input fields for "Account Number" and "Amount," buttons for "Deposit," "Withdraw," and "Check Balance," and the result area displaying a message like "Deposit successful."]

To add a screenshot:





Run the program and perform an action (e.g., deposit $500 to account "12345").



Take a screenshot of the GUI.



Save it as screenshot.png in the project root.





Future Scope





Add user authentication for secure access.



Implement transaction history to track deposits and withdrawals.



Integrate a database for persistent storage of account data.

Acknowledgments

This project was developed as part of a hackathon submission on May 27, 2025, by the team listed above.
