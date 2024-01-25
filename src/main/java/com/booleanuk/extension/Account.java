package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private static int lastAccountNumber = 0;
    private int accountNr;
    private double balance;
    private List<Transaction> transactions;

    public Account() {
        this.accountNr = lastAccountNumber + 1;
        lastAccountNumber ++;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public boolean add(double amount){
        this.balance += amount;
        this.transactions.add(new Transaction(amount, this.balance));
        return false;
    }

    public boolean remove(double amount){
        this.balance -= amount;
        this.transactions.add(new Transaction(-amount, this.balance));
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getAccountNr() {
        return accountNr;
    }

    //Only for testing purposes
    public static void resetLastAccountNumber() {
        lastAccountNumber = 0;
    }
}
