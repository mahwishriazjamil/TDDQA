package com.mahwishriazjamil.domain;

import com.mahwishriazjamil.interfaces.Printable;

import java.math.BigDecimal;
import java.util.List;

public abstract class Account implements Printable {

	protected String name;
	protected int sortCode;
	protected int accountNumber;
	protected BigDecimal balance;
	
	public Account(String name, int sortCode, int accountNumber, BigDecimal balance){
		this.name = name;
		this.sortCode = sortCode;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	abstract void transfer(Account account, BigDecimal amount);
	abstract List<Balance> checkBalance();
	abstract void withdraw(BigDecimal amount);
	abstract void deposit(BigDecimal amount);

}
