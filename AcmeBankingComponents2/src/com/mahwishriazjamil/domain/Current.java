package com.mahwishriazjamil.domain;

import java.math.BigDecimal;

public class Current extends Account {
	
	public Current(String name, int sortCode, int accountNumber, BigDecimal balance) {
		super(name, sortCode, accountNumber, balance);
	}
	
	@Override
	public void transfer(Account account, BigDecimal amount) {
		withdraw(amount);
		account.deposit(amount);
	}
	
	@Override
	public Balance checkBalance() {
		// create, instantiate and pass current account into the balance object
		return new Balance(balance,this);
	}
	
	@Override
	public void withdraw(BigDecimal amount) {
		if (amount.doubleValue() > balance.doubleValue() || amount.doubleValue() < 0) {
			throw new IllegalArgumentException("Amount to withdraw needs to be greater than 0 and less than available balance");
		}
		balance = balance.subtract(amount);
	}
	
	@Override
	public void deposit(BigDecimal amount) {
		if (amount.doubleValue() <= 0.0){
			throw new IllegalArgumentException("Amount to deposit needs to be greater than 0!");
		}
		balance = balance.add(amount);
	}
	
	@Override
	public void print() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
