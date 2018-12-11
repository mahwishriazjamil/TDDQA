package riazjamil.mahwish.app;

import riazjamil.mahwish.domain.Calculator;

import java.util.Scanner;

public class Day1Revision {
	public static void main(String[] args) {
		
		// String input
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number...");
		double number1 = input.nextDouble();
		System.out.println("Please enter a second number...");
		double number2 = input.nextDouble();
		System.out.println("Which operation would you like to perform with these two numbers?");
		String operation = input.next();
		
		if (operation.equals("+")){
			System.out.println("Your two numbers added equal " + Calculator.add(number1, number2));
		}
		
		if (operation.equals("-")){
			System.out.println("Your two numbers subtracted equal " + Calculator.subtract(number1, number2));
		}
		
		if (operation.equals("*")){
			System.out.println("Your two numbers multiplied equal " + Calculator.multiply(number1, number2));
		}
		
		if (operation.equals("/")){
			System.out.println("Your two numbers divided equal " + Calculator.divide(number1, number2));
		}
		
	}
	
}
