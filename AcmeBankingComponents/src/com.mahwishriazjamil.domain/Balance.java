package com.mahwishriazjamil.domain;

import java.math.BigDecimal;

public class Balance {
	
	public enum Type {
		ACTUAL, AVAILABLE
	}
	private final Account account;
	private final BigDecimal amount;
	
	public Balance(BigDecimal amount, Account account){
		this.account = account;
		this.amount = amount;
	}
	
	public BigDecimal getAmount(){
		return amount;
	}
	
}
