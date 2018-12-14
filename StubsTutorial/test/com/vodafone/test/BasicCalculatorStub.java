package com.vodafone.test;

import com.company.BasicCalculatorService;

public class BasicCalculatorStub implements BasicCalculatorService {
	
	public BasicCalculatorStub(){
	
	}
	
	@Override
	public double fibonacciAdd(double x, double y) {
		return 9999;
	}
	
	@Override
	public double fibonacciSubtract(double x, double y) {
		return -9999;
	}
}
