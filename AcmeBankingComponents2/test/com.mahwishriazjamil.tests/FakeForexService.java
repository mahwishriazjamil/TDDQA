package com.mahwishriazjamil.tests;

import com.mahwishriazjamil.domain.Rate;
import com.mahwishriazjamil.interfaces.ForexService;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

public class FakeForexService implements ForexService {
	
	public FakeForexService(){
	
	}
	
	private Dictionary<String, Rate> getRateDate(){
		
		Dictionary<String, Rate> myRates = new Hashtable<>();
		
		myRates.put("USD", new Rate("USD", new Date(),1.26));
		myRates.put("EUR", new Rate("EUR", new Date(),1.11));
		myRates.put("JPY", new Rate("JPY", new Date(),142.44));
		myRates.put("AUD", new Rate("AUD", new Date(),1.74));
		
		return myRates;
	}
	
	@Override
	public double getRateByCode(String code) {
		return getRateDate().get(code).getValue();
	}
	
	@Override
	public Dictionary<String, Rate> getRates(String code) {
		return null;
	}
	
	
}
