package com.mahwishriazjamil.domain;

import java.math.BigDecimal;


public class Current extends Account{
	
	
	public Current(String name, int sortCode, int accountNumber, BigDecimal balance) {
		super(name, sortCode, accountNumber, balance);
	}
	
	@Override
	public void transfer(Account account, BigDecimal amount) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	@Override
	public Balance checkBalance() {
		// create, instantiate and pass current account into the balance object
		return new Balance(balance,this);
	}
	
	@Override
	public void withdraw(BigDecimal amount) {
		balance = balance.subtract(amount);
	}
	
	@Override
	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}
	
	@Override
	public void print() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
