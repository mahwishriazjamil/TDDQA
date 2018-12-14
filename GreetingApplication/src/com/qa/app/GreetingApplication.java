package com.qa.app;

import com.qa.domain.Greeter;
import com.qa.domain.MessageSpecialCaseFormatter;
import com.qa.interfaces.MessageFormatter;

import java.util.Scanner;

public class GreetingApplication {

    public static void main(String[] args) {
	
        try(Scanner myScanner = new Scanner(System.in)){
            System.out.println("Please enter a greeting...");
            String greeting = myScanner.next();
            // using component MessageSpecialCaseFormatter
            MessageFormatter formatter = new MessageSpecialCaseFormatter();
            Greeter gt = new Greeter(formatter);
    
            System.out.println("The greeting is: " + gt.greet(greeting));
        }
        
    }
}
