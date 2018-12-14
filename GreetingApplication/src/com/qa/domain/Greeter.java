package com.qa.domain;

import com.qa.interfaces.MessageFormatter;

public class Greeter {
	
	private MessageFormatter formatter;
	
	public Greeter(MessageFormatter formatter) {
		this.formatter = formatter;
		
	}
	
	public String greet(String message) {
		
		return formatter.transform(message);
		
	}
	
	
	
}
