import com.vodafone.domain.MathApplication;
import com.vodafone.interfaces.BasicCalculatorService;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class MathApplicationTest {

	@Test
	public void testFibonacciAddition() {
		// Arrange
		BasicCalculatorService mockCalculatorService = createMock(BasicCalculatorService.class);
		expect(mockCalculatorService.fibonacciAdd(10, 20)).andReturn(30.0);
		replay(mockCalculatorService);
		
		MathApplication app = new MathApplication(mockCalculatorService);
		double expected = app.fibonacciAdd(10, 20);
		
		assertEquals(30.0, expected, 1e-4);
		// there was an interaction between service and collaborator
		verify(mockCalculatorService);
	}
	
	@Test
	public void testFibonacciSubtraction() {
		// Arrange
		BasicCalculatorService mockCalculatorService = createMock(BasicCalculatorService.class);
		expect(mockCalculatorService.fibonacciSubtract(10, 20)).andReturn(25.0);
		replay(mockCalculatorService);
		
		MathApplication app = new MathApplication(mockCalculatorService);
		double expected = app.fibonacciSubtract(10, 20);
		
		assertEquals(25.0, expected, 1e-4);
		// there was an interaction between service and collaborator
		verify(mockCalculatorService);
	}
}