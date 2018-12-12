package com.vodafone.mahwishriazjamil.domain;

import com.vodafone.mahwishriazjamil.interfaces.StockWebService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StockInformation  {
	
	// fields
	private int userID;
	private String password;
	private String symbol;
	private boolean available;
	private boolean exists;
	private String companyName;
	private double currentPrice; // deviated from spec - changed from int to double as more precise
	private int numberOfSharesOutstanding;
	// number of shares * latest trading .. use setMarket... method
	private int marketCapitalisationInMillions;
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8})";
	private Pattern pattern;
	private Matcher matcher;
	private boolean isLoggedIn;
	private String stockData;
	
	// constructor
	public StockInformation(int userID, String password, String symbol, StockWebService stockWebService) {

		if (authenticateUserID(userID) && authenticatePassword(password)){
			this.userID = userID;
			this.password = password;
			this.symbol = symbol;
			isLoggedIn = stockWebService.authenticate(userID, password);
			
			if (isLoggedIn){
				stockData = stockWebService.getStockInfo(symbol);
				parseStockData(stockData);
			}
		}
		
	}
	
	private void parseStockData(String stockData) {
		// parse/split string, store value in variable, use variable to set corresponding fields.
		String[] splitString = stockData.split(",");
		
		this.setSymbol(splitString[0]);
		this.setCompanyName(splitString[1]);
		this.setCurrentPrice(Double.parseDouble(splitString[2]));
		this.setMarketCapitalisationInMillions(Integer.parseInt(splitString[3]));
	}
	
	// getters
	public int getUserID() {
		return userID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getSymbol() {
		return symbol.toUpperCase();
	}
	
	public boolean getAvailable(){
		return available;
	}
	
	public boolean getExists(){
		return exists;
	}
	
	public String getCompanyName(){
		return companyName;
	}
	
	public double getCurrentPrice(){
		return currentPrice;
	}
	
	public int getNumberOfSharesOutstanding(){
		return numberOfSharesOutstanding;
	}
	
	public int getMarketCapitalisationInMillions(){
		return (int) Math.ceil(marketCapitalisationInMillions);
	}
	
	// setters
	public void setUserID(int userID){
		this.userID = userID;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	private void setSymbol(String symbol){
		this.symbol = symbol;
	}
	
	private void setAvailable(boolean available){
		this.available = available;
	}
	
	private void setExists(boolean exists){
		this.exists = exists;
	}
	
	private void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
	private void setCurrentPrice(double currentPrice){
		this.currentPrice = currentPrice;
	}
	
	private void setNumberOfSharesOutstanding(int numberOfSharesOutstanding){
		this.numberOfSharesOutstanding = numberOfSharesOutstanding;
	}
	
	private void setMarketCapitalisationInMillions(int marketCapitalisationInMillions){
		this.marketCapitalisationInMillions = marketCapitalisationInMillions;
	}
	
	@Override
	public String toString() {
		return  this.getCompanyName() + " " +
				this.getSymbol() + " " +
				this.getCurrentPrice();
	}
	

	private boolean authenticateUserID(int userID){
		boolean correctUserIDFormat = false;
		if (userID < 1 || userID > 9999){
			this.setCompanyName("Not allowed");
			throw new IllegalArgumentException("User ID must be an integer value between 1 and 9999!");
		}
		else {
			correctUserIDFormat = true;
		}
		return correctUserIDFormat;
	}
	
	
	private boolean authenticatePassword(String password){
		boolean correctPasswordFormat = false;
		if (!password.matches(PASSWORD_PATTERN)){
			throw new IllegalArgumentException("Password must be a string of characters with a combination of upper and lowercase, numbers and symbols, and at least 8 characters in length.");
		}
		else {
			correctPasswordFormat = true;
		}
		return correctPasswordFormat;
	}
	
	
}
