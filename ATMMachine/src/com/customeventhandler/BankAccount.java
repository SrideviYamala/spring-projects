package com.customeventhandler;

abstract class BankAccount {
    private int accNum;
    private String accHolder;
    protected Double accBalance;

    BankAccount(int accNum, String accHolder, Double accBalance) {
        super();
        this.accNum = accNum;
        this.accHolder = accHolder;
        this.accBalance = accBalance;
    }

    void showBalance() {
        System.out.println(accBalance);
    }

    abstract double withdraw(double amount);

    abstract double deposit(double amount);

    @Override
    public String toString() {
        return "BankAccount [accBalance=" + accBalance + ", accHolder=" + accHolder + ", accNum=" + accNum + "]";
    }
}
