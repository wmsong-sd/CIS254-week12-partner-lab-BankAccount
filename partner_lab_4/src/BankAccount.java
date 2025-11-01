/**
 * Lab Title: BankAccount 
 * Course: CIS 254 
 * Description: Represents a simple bank account that allows deposits and withdrawals.
 * Records transactions using a StringBuilder.
 * 
 * @author Wonmin Song (BankAccount.java)
 * @author Joel Odessky (Application.java)
 * @since 10/30/2025
 */

import java.util.Calendar;

/** The {@code BankAccount} class models a simple bank account with basic
 * operations such as deposit, withdraw, and retrieving account statements.
 * It maintains a running transaction log using a {@link StringBuilder} and
 * records the date and time of each transaction using {@link Calendar}.
 */
public class BankAccount {

    private static int nextAccountNumber = 10000;

    private int accountNumber;
    private double balance;
    StringBuilder transactions;

    /**
     * Default constructor
     * Initializes balance to 0.0 and creates an empty transaction log.
     */
    public BankAccount() {
        accountNumber = generateAccountNumber();
        balance = 0.0;
        transactions = new StringBuilder();
    }

    /**
     * Overloaded constructor
     * Initializes balance with a given amount.
     * 
     * @param amount the initial deposit amount
     */
    public BankAccount(double amount) {
        accountNumber = generateAccountNumber();
        balance = amount;
        transactions = new StringBuilder();
    }

    /**
     * Deposits money into the account if the amount is positive.
     * 
     * @param amount amount to money to deposit
     * @throws Exception if amount is negative
     */
    void deposit(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount cannot be negative");
        } else {
            balance += amount;
            String date = getCurrentDateTime();
            transactions.append("Date: " + date + " | Deposited " + amount + "\n");
        }
    }

    /**
     * Withdraws money from the account if there are sufficient funds.
     * 
     * @param amount amount of money to withdraw
     * @throws Exception if amount is negative or exceeds balance
     */
    void withdraw(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount cannot be negative");
        } else if (balance < amount) {
            throw new Exception("Not enough funds");
        } else {
            balance -= amount;
            String date = getCurrentDateTime();            
            transactions.append("Date: " + date + " | Withdrew " + amount + "\n");
        }
    }

    /**
     * Returns the current account balance.
     * 
     * @return current balance
     */
    double getBalance() {
        return balance;
    }

    /**
     * Returns this account's numeric account number.
     *
     * @return the account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    /**
     * Returns a read-only string containing the full transaction history.
     *
     * @return the transaction log text
     */
    public String getStatement() {
        return transactions.toString();
    }

    /**
     * Generates the next sequential numeric account number.
     * This method uses a shared static counter and returns the current value,
     * then increments it for the next account to be created.
     *
     * @return the newly assigned numeric account number
     */
    private static int generateAccountNumber() {
        return nextAccountNumber++;
    }

    /**
     * Returns the current date and time as a formatted string.
     * 
     *@return formatted date/time
     */
    private String getCurrentDateTime() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);

        return String.format("%04d/%02d/%02d %02d:%02d", year, month, day, hour, minute);
    }
}

