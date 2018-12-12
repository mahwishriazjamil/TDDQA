package com.mahwishriazjamil.tests;

import com.mahwishriazjamil.domain.Account;
import com.mahwishriazjamil.domain.Balance;
import com.mahwishriazjamil.domain.Current;
import com.mahwishriazjamil.interfaces.ForexService;
import org.junit.*;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class CurrentAccountTest {
	
	// fields
	private Account currentAccount;
	
	// empty constructor
	public CurrentAccountTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		String name =  "Jonny Doe";
		int sortCode = 548943;
		int accountNumber = 43345445;
		BigDecimal openingBalance = new BigDecimal(120.50);
		
	
		currentAccount = new Current(name, sortCode, accountNumber, openingBalance);
	}
	
	@Test
	public void testDeposit() {
		
		// Arrange
		BigDecimal amountToDeposit = new BigDecimal(5.20);
		BigDecimal expectedBalance = new BigDecimal(125.70);
		
		// Act
		currentAccount.deposit(amountToDeposit);
		Balance actualBalance = currentAccount.checkBalance();
		
		// Assert
		assertEquals(expectedBalance, actualBalance.getAmount());
		
	}
	
	// balance should go down
	@Test
	public void testWithdraw(){
		
		// Arrange
		BigDecimal amountToWithdraw = new BigDecimal(10.00);
		BigDecimal expectedBalance = new BigDecimal(110.5);
		double delta = 1e-3;
		// Act
		currentAccount.withdraw(amountToWithdraw);
		Balance actualBalance = currentAccount.checkBalance();
		
		// Assert
		assertEquals(expectedBalance.doubleValue(), actualBalance.getAmount().doubleValue(), delta);
	}
	
	@Test
	public void testTransfer(){
		// Arrange
		BigDecimal amountToTransfer = new BigDecimal(5.20);
		Account beneficiaryAccount = new Current ("Anne Doe", 000000, 12345678, new BigDecimal("12.50"));
		double delta = 1e-3;
		// Act
		currentAccount.transfer(beneficiaryAccount, amountToTransfer); // unit under test
		
		// Assert
		BigDecimal actualBeneficiaryBalance = beneficiaryAccount.checkBalance().getAmount();
		BigDecimal expectedBeneficiaryBalance = new BigDecimal("17.70");
		assertEquals(expectedBeneficiaryBalance.doubleValue(), actualBeneficiaryBalance.doubleValue(), delta);
	}
	
	@Test
	public void testGetEuroBalance(){
		// Arrange (following is a stub)
		ForexService fakeForexService = new FakeForexService();
		// 1.11 - EUR-GBP rate
		currentAccount.setForexService(fakeForexService);
		BigDecimal expectedEuroBalance = new BigDecimal(Double.toString(133.755));
		
		// Act
		Balance actualBalanceEuro = currentAccount.checkBalance("EUR");
		
		// Assert
		assertEquals(expectedEuroBalance, actualBalanceEuro.getAmount());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenDepositIsLessThanZero(){
		
		BigDecimal amountToDeposit = new BigDecimal(-5.20);
		currentAccount.deposit(amountToDeposit);
	}
	
}

















