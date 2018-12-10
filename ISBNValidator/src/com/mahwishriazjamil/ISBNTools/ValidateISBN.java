package com.mahwishriazjamil.ISBNTools;


public class ValidateISBN {
	
	
	public boolean checkISBN(String ISBN) {
		
		if (ISBN.length() != 10) throw new NumberFormatException("ISBN needs to be 10 digits long!");
		
		
		int total = 0;
		
		for (int i = 0; i < 10; i++){
			
			// if char at index i != a number...  / if its not a character
			if (!Character.isDigit(ISBN.charAt(i))) {
				if ((i == 9) && (ISBN.charAt(i) == 'X')){
					total += 10;
				}
				
				else {
					throw new NumberFormatException("ISBN numbers can only contain numbers");
				}
			}
			total += ISBN.charAt(i) * (10 - i);
		}
		
		if (total % 11 == 0){
			return true;
		}
		
		else {
			return false;
		}
	}
	
//	int CheckISBN(int const digits[10]) {
//		int i, s = 0, t = 0;
//
//		for (i = 0; i < 10; i++) {
//			t += digits[i];
//			s += t;
//		}
//		return s % 11;
//	}
}
