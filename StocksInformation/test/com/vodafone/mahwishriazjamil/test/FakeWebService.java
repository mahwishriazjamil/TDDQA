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
	
	private Map<String,String> getData(){
		Map<String,String> stockData = new HashMap<>();
		stockData.put("AMZN", "AMZN, Amazon, 11950.8, 200000000");
		stockData.put("EBAY", "?,?,?,?");
		stockData.put("IBM", "?,?,?,?");
		stockData.put("ESL", "?,?,?,?");
		
		return stockData;
	}
	
	@Override
	public String getStockInfo(String symbol) {
		// get value within, using key value
		
		return getData().get(symbol);
	}
}
