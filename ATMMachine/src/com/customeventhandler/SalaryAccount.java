package com.customeventhandler;

public class SalaryAccount extends BankAccount {

    SalaryAccount(int accNum, String accHolder, Double accBalance) {
        super(accNum, accHolder, accBalance);

    }

    @Override
    double withdraw(double amount) {
        if (amount > 100000) {
            System.out.println("Withdrawl limit exceeded");
        }
        this.accBalance -= amount;
        return this.accBalance;
    }

    @Override
    double deposit(double amount) {
        this.accBalance += amount;
        return this.accBalance;
    }
}
