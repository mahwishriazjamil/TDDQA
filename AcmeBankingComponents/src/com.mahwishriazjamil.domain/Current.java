package com.mahwishriazjamil.domain;

import java.math.BigDecimal;
import java.util.List;

public class Current extends Account{
	
	
	public Current(String name, int sortCode, int accountNumber, BigDecimal balance) {
		super(name, sortCode, accountNumber, balance);
	}
	
	@Override
	void transfer(Account account, BigDecimal amount) {
	
	}
	
	@Override
	List<Balance> checkBalance() {
		return null;
	}
	
	@Override
	void withdraw(BigDecimal amount) {
	
	}
	
	@Override
	void deposit(BigDecimal amount) {
	
	}
}
