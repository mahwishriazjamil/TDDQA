package com.vodafone.test;

import com.company.BasicCalculatorService;
import com.company.MathApplication;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathApplicationTest {
	
	public MathApplicationTest(){
	
	}
	
	@Test
	public void testAdd(){
		
		// Arrange
		BasicCalculatorService basicCalculatorService = new BasicCalculatorStub();
		MathApplication app = new MathApplication(basicCalculatorService);
		double expectedResult = 9999;
		
		// Act
		double actualResult = app.fibonacciAdd(10d, 20d);
		
		// Assert
		assertEquals(expectedResult, actualResult, 1e-2);
		
	}
	
	@Test
	public void testFibonacciSubtraction(){
		
		// Arrange
		BasicCalculatorService basicCalculatorService = new BasicCalculatorStub();
		MathApplication app = new MathApplication(basicCalculatorService);
		double expectedResult = -9999;
		
		// Act
		double actualResult = app.fibonacciSubtract(10d, 20d);
		
		// Assert
		assertEquals(expectedResult, actualResult, 1e-2);
		
	}
	
}