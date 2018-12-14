package com.qa.interfaces;

public interface MessageFormatter {
	
	String transform(String message);
	
	void sendEmail(String to, String message);
	
}
