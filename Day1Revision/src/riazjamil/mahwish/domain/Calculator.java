package riazjamil.mahwish.domain;

public class Calculator {
	
	
	
	
	public static double add(double x, double y) {
		return x + y;
		
	}
	
	public static double subtract(double x, double y) {
		return x - y;
	}
	
	public static double multiply(double x, double y) {
		return x * y;
	}
	
	public static double divide(double x, double y) {
		if (y == 0){
			throw new ArithmeticException("Divisor cannot be 0!");
		}
		return x / y;
	}
	
	
	public static double add(int[] myArray) {
		double actual = 0;
		for (int number : myArray){
			actual += number;
		}
		return actual;
	}
	
	
	public static double average(int[] myArray) {
		double actual = 0;
		for (double number : myArray){
			actual += number;
		}
		return actual / myArray.length;
	}
	
	public static String addString(String[] myArray) {
		StringBuilder sb = new StringBuilder();

		for (String value : myArray){
			sb.append(value);
		}
		return sb.toString();

	}
}
