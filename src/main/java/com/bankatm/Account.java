package com.bankatm;

public class Account {

    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String toCsvString(){
        return this.accountNumber + "," + this.pin + "," + this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit (double amount) {
        if(amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw (double amount){
        if(amount > 0 && balance  >= amount){
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public boolean validatePin(String enteredPin){
        if(this.pin.equals(enteredPin)){
            return true;
        }
        return false;
    }
}
