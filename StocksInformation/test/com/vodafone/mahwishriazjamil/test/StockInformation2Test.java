package com.vodafone.mahwishriazjamil.test;

import com.vodafone.mahwishriazjamil.domain.StockInformation;
import com.vodafone.mahwishriazjamil.interfaces.StockWebService;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class StockInformation2Test {
	
	@Test
	public void testGetStockInformationWhenAuthenticated(){
		StockWebService mockService = createMock(StockWebService.class);
		String password = "!za8Abcd";
		int userId = 999;
		String symbol = "ACME";
		
		StockInformation si = new StockInformation(userId, password, symbol, mockService);
		
		expect(mockService.authenticate(userId,password)).andReturn(Boolean.TRUE);
		expect(mockService.getStockInfo(symbol)).andReturn("ACME,Acme Ltd,123,56,3564500");
		
		String actualSymbol = si.getSymbol();
		
		replay(mockService);
		assertEquals(symbol, actualSymbol);
		
		verify(mockService);
		
		//testing
		// act is missing. si needs to be used
	}
	
}