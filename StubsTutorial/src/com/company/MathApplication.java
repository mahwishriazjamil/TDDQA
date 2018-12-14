package com.company;
// consumer
public class MathApplication {
	
	private BasicCalculatorService basicCalculatorService;
	
	public MathApplication(BasicCalculatorService basicCalculatorService){
		this.basicCalculatorService = basicCalculatorService;
	}
	
	// testing if the 'fibonacciAdd' method is called
	public double fibonacciAdd(double x, double y){
		return basicCalculatorService.fibonacciAdd(x,y);
	}
	
	// testing if the 'fibonacciSubtract' method is called
	public double fibonacciSubtract(double x, double y){
		return basicCalculatorService.fibonacciSubtract(x,y);
	}
	
	
	
}
