package riazjamil.mahwish.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import riazjamil.mahwish.domain.Calculator;

import static org.junit.Assert.*;

public class CalculatorTest {
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAdd(){
		// Arrange
		double expected = 23;
		
		// Act
		double actual = Calculator.add(12,11);
		double delta = 1e-2;
		
		// Assert
		assertEquals(expected, actual, delta);
	}
	@Test
	public void testSubtract(){
		// Arrange
		double expected = 1;
		
		// Act
		double actual = Calculator.subtract(12,11);
		double delta = 1e-2;
		
		// Assert
		assertEquals(expected, actual, delta);
	}
	@Test
	public void testMultiply(){
		// Arrange
		double expected = 60;
		
		// Act
		double actual = Calculator.multiply(30,2);
		double delta = 1e-2;
		
		// Assert
		assertEquals(expected, actual, delta);
	}
	@Test (expected=ArithmeticException.class)
	public void testDivide(){
		// Arrange
		double expected = 15;
		
		// Act
		double actual = Calculator.divide(30,2);
		double delta = 1e-2;
		
		// Assert
		assertEquals(expected, actual, delta);
	}
	
	@Test
	public void testAddArrayElements(){
		// Arrange
		double expected = 60;
		
		// Act
		double actual = Calculator.add(new int [] {30, 20, 10});
		double delta = 1e-2;
		
		// Assert
		assertEquals(expected, actual, delta);
	}
	
	@Test
	public void testAverageElements(){
		// Arrange
		double expected = 20;
		
		// Act
		double actual = Calculator.average(new int [] {30, 20, 10});
		double delta = 1e-2;
		
		// Assert
		assertEquals(expected, actual, delta);
	}
	
	@Test
	public void testNumbersToString(){
		// Arrange
		String expected = "OneTwoThree";
		String[] words = {"one", "two", "three"};
		// Act
		String actual = Calculator.addString(words);
		
		// Assert
		assertTrue(expected.equalsIgnoreCase(actual));

	}
}