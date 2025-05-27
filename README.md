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

Features





Deposit Money: Add funds to an account with input validation.



Withdraw Money: Withdraw funds, adhering to account-specific rules (e.g., minimum balance for Savings, overdraft limit for Current).



Check Balance: View the current balance of an account.



Account Types:





Savings Account: Requires a minimum balance of $100.



Current Account: Allows an overdraft limit of $500.



GUI: Built using Swing for user-friendly interaction.

Project Structure





main/Main.java: Entry point of the application.



model/Account.java: Abstract class for accounts.



model/SavingsAccount.java: Savings account implementation.



model/CurrentAccount.java: Current account implementation.



util/AccountStorage.java: Manages account data using a HashMap.



ui/BankUI.java: GUI implementation using Swing.

Setup Instructions





Prerequisites:





Java Development Kit (JDK) 8 or higher.



An IDE like IntelliJ IDEA, Eclipse, or a simple text editor with a Java compiler.



Clone the Repository (if applicable):

git clone [your-repository-link]

(Replace [your-repository-link] with the actual Git repository URL if available.)



Compile and Run:





Open the project in your IDE.



Compile and run Main.java to launch the GUI.



Alternatively, from the terminal:

javac main/Main.java
java main.Main

Usage Guide





Launch the Application:





Run the program to open the GUI window titled "Basic Banking System."



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
