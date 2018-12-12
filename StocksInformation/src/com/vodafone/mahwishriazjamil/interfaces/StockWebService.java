package com.vodafone.mahwishriazjamil.interfaces;

public interface StockWebService {
	
	boolean authenticate (int userID, String password);
	
	String getStockInfo (String symbol);
	
}
