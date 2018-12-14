package com.vodafone.domain;

import com.vodafone.interfaces.BasicCalculatorService;

public class MathApplication {
	
	private BasicCalculatorService basicCalculatorService;
	
	public MathApplication(BasicCalculatorService calc){
		this.basicCalculatorService = calc;
	}
	
	public double fibonacciAdd(double x, double y){
		return basicCalculatorService.fibonacciAdd(x, y);
	}
	
	public double fibonacciSubtract(double x, double y){
		return basicCalculatorService.fibonacciSubtract(x, y);
	}
	
}
