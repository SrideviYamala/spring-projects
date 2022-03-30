package com.customeventhandler;

import java.sql.Timestamp;

import org.springframework.context.ApplicationEvent;

public class WithdrawlEvent extends ApplicationEvent{
	double accBalance;

    public WithdrawlEvent(Object source, double accBalance) {
        super(source);
        this.accBalance = accBalance;
    }

    @Override
    public String toString() {
        return "Amount Withdrawn from your account! \n"+"Your account balance: "+this.accBalance
        		+"\n"+"Current Time: "+new Timestamp(System.currentTimeMillis());
    }
}
