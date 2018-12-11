package com.mahwishriazjamil.domain;

import java.util.Date;

public class Rate {

	// immutable values (read-only)
	private final String code;
	private final Date dateOfRate;
	private final double value;
	
	public Rate(String code, Date dateOfRate, double value) {
		this.code = code;
		this.dateOfRate = dateOfRate;
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	
	public Date getDateOfRate() {
		return dateOfRate;
	}
	
	public double getValue() {
		return value;
	}
}
