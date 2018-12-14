package com.vodafone.test;

import com.vodafone.domain.StockInformation;
import com.vodafone.interfaces.StockWebService;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class StockInformation2Test {
	
	@Test
	public void testGetStockInformationWhenAuthenticated(){
		StockWebService mochService = createMock(StockWebService.class);
		String password = "!za8Abcd";
		int userId = 999;
		String symbol = "ACME";
		StockInformation si = new StockInformation(symbol, userId, password, mockService);
		
		expect(mockService.authenticate(userId,password)).andReturn(Boolean.TRUE);
		expect(mockService.getStockInfo(symbol)).andReturn("ACME,Acme Ltd,123,56,3564500");
		
		String actualSymbol = si.getSymbol();
		
		replay(mockService);
		assertEquals(symbol, actualSymbol);
		
		verify(mockService);
		// act is missing. si needs to be used
	}
	
}