package com.mahwishriazjamil.domain;

import com.mahwishriazjamil.interfaces.ForexService;
import com.mahwishriazjamil.interfaces.Printable;

import java.math.BigDecimal;

public abstract class Account implements Printable {
	
	protected String name;
	protected int sortCode;
	protected int accountNumber;
	protected BigDecimal balance;
	protected ForexService service;
	
	public Account(String name, int sortCode, int accountNumber, BigDecimal balance){
		this.name = name;
		this.sortCode = sortCode;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public abstract void transfer(Account account, BigDecimal amount);
	public abstract Balance checkBalance();
	public abstract void withdraw(BigDecimal amount);
	public abstract void deposit(BigDecimal amount);
	
	
	public void setForexService(ForexService service){
		this.service = service;
	}
	
	public Balance checkBalance(double euroRate) {
		return new Balance(balance.multiply(new BigDecimal(Double.toString(euroRate))),this);
		
		
	}
}
