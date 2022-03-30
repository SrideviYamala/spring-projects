package com.customeventhandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		WithdrawlEventPublisher publisher = (WithdrawlEventPublisher) context.getBean("customEventPublisher");
		BankAccount acc = new SavingsAccount(119, "Sridevi", 20000.0);
		double balance=acc.withdraw(5000);
		publisher.publish(balance);
	}

}