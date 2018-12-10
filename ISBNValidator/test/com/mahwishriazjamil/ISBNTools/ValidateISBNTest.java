package com.mahwishriazjamil.ISBNTools;

import org.junit.Test;

import static org.junit.Assert.*;


public class ValidateISBNTest {
	
	@Test
	public void checkAValidISBN(){
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		
		assertTrue("first val: ", result); // if the value of result == true, test will pass. else, fail.
		result = validator.checkISBN("0140177396");
		assertTrue("second val: ", result);
		
	}
	
	@Test
	public void ISBNNumbersEndingInAnXAreValid(){
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void checkAnInvalidISBN(){
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result); // if the value of result == true, test will pass. else, fail.
		
	}
	
	@Test (expected = NumberFormatException.class)
	public void nineDigitISBNsAreNotAllowed(){
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("123456789");
	}
	
	@Test (expected = NumberFormatException.class)
	public void nonNumericISBNsAreNotAllowed(){
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("helloworld");
	}
	
}
