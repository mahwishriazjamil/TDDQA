package com.mahwishriazjamil.tests;

import com.mahwishriazjamil.domain.Account;
import com.mahwishriazjamil.domain.Balance;
import com.mahwishriazjamil.domain.Current;
import com.mahwishriazjamil.interfaces.ForexService;
import org.junit.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class CurrentAccountTest {
	private Account currentAccount;
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
	
	@After
	public void tearDown() {
		System.out.println("I am running after");
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
	@Test(expected = IllegalArgumentException.class)
	public void testWithdraw(){
		
		// Arrange
		BigDecimal amountToWithdraw = new BigDecimal(10.00);
		BigDecimal expectedBalance = new BigDecimal(100.00);
		
		// Act
		currentAccount.withdraw(amountToWithdraw);
		Balance actualBalance = currentAccount.checkBalance();
		
		// Assert
		assertEquals(expectedBalance, actualBalance.getAmount());
	}
	
	@Test
	public void testTransfer(){
		// Arrange
		BigDecimal amountToTransfer = new BigDecimal(5.20);
//		Account beneficiaryAccount = new Current ("Anne Doe", 000000, new BigDecimal("12.50"), 12345678);
		
		// Act
//		currentAccount.transfer(beneficiaryAccount, amountToTransfer); // unit under test
		
		// Assert
//		BigDecimal.actualBeneficiaryBalance(beneficiaryAccount.checkBalance().getAmount());
		BigDecimal expectedBeneficiaryBalance = new BigDecimal("17.70");
//		assertEquals(expectedBeneficiaryBalance, actualBeneficiaryBalance);
	}
	
	@Test
	public void testGetBalanceAsEuro(){
		// Arrange (following is a stub)
		ForexService fakeForexService = new FakeForexService();
		// 1.11 - EUR-GBP rate
		BigDecimal expectedEuroBalance = new BigDecimal(Double.toString(133.755));
		double euroRate = fakeForexService.getRateByCode("EUR");
		
		// Act
		Balance actualBalanceEuro = currentAccount.checkBalance(euroRate);
		
		// Assert
		assertEquals(expectedEuroBalance, actualBalanceEuro);
	}
	
	@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenDepositIsLessThanZero(){
		
		BigDecimal amountToDeposit = new BigDecimal(-5.20);
		currentAccount.deposit(amountToDeposit);
	}
	
}

















