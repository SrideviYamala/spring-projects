package com.customeventhandler;

public class SavingsAccount extends BankAccount {

    SavingsAccount(int accNum, String accHolder, Double accBalance) {
        super(accNum, accHolder, accBalance);

    }

    @Override
    double withdraw(double amount) {
        if (amount > 30000) {
            System.out.println("Withdrawl limit exceeded");
        }
        this.accBalance -= amount;
        return this.accBalance;
    }

    @Override
    double deposit(double amount) {
        if (amount > 1000000) {
            System.out.println("Max deposit limit exceeded");
        }
        this.accBalance += amount;
        return this.accBalance;
    }

}
