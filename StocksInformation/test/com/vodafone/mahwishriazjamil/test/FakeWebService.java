package com.vodafone.mahwishriazjamil.test;

import com.vodafone.mahwishriazjamil.interfaces.StockWebService;

import java.util.HashMap;
import java.util.Map;

public class FakeWebService implements StockWebService {
	
	
	@Override
	public boolean authenticate(int userID, String password) {
		// validate and login if all values are valid
		return true;
	}
	
//	current price, number of shares outstanding
	// using dependency injection to gain data
	private Map<String,String> getData(){
		Map<String,String> stockData = new HashMap<>();
		// symbol, name, price per share, numbers of share outstanding?
		stockData.put("AMZN","AMZN,Amazon,11950.8,20000");
		stockData.put("EBAY","EBAY,ebay,11950.8,20000");
		stockData.put("IBM","AMZN,Amazon,11950.8,20000");
		stockData.put("ESL","AMZN,Amazon,11950.8,20000");
		
		return stockData;
	}
	
	@Override
	public String getStockInfo(String symbol) {
		// get value within, using key value
		
		return getData().get(symbol);
	}
}
