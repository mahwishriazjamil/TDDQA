package com.vodafone.mahwishriazjamil.test;

import com.vodafone.mahwishriazjamil.domain.StockInformation;
import com.vodafone.mahwishriazjamil.interfaces.StockWebService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StockInformationTest {
	
	private StockInformation stockInformation;
	
	@Before
	public void setUp() throws Exception {
		

	}
	
	@After
	public void tearDown() throws Exception {
	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAuthenticateShouldThrowWhenPasswordIsInvalid(){
		/*
		An integer value between 1 and 9999.
		If this cannot be authenticated by the web service component,
			the company name will be set to “Not allowed”
			and all other values will be set to appropriate dummy values (zeroes or spaces).
		 */
		
		// Arrange
		int userID = 1234;
		String password = "G&9QU&CL";
		String symbol = "AMZN";
		StockWebService stockWebService = new FakeWebService();
		
		StockInformation stockInformation = new StockInformation(userID, password, symbol, stockWebService);
		
	}
	
	@Test
	public void testAuthenticateShouldThrowWhenPasswordIsValid(){
		
		// Arrange
		double delta = 1e-3;
		int userID = 1234;
		String password = "!zai1codnA";
		String symbol = "AMZN";
		StockWebService stockWebService = new FakeWebService();
		double expectedPrice = 11950.8;
		
		// Act
		StockInformation stockInformation = new StockInformation(userID, password, symbol, stockWebService);
		double actualPrice = stockInformation.getCurrentPrice();
		
		// Assert
		assertEquals(expectedPrice, actualPrice, delta);
		
	}
	
	@Test
	public void testGetStockInfo(){
		/*
		An integer value between 1 and 9999.
		If this cannot be authenticated by the web service component,
			the company name will be set to “Not allowed”
			and all other values will be set to appropriate dummy values (zeroes or spaces).
		 */
		
	}
}