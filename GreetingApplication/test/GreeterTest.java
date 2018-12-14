import com.qa.domain.Greeter;
import com.qa.interfaces.MessageFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class GreeterTest {
	
	private MessageFormatter mockFormatter;
	private Greeter greeter;
	
	public GreeterTest(){
	
	}
	
	@Before
	public void initialise(){
		mockFormatter = createMock(MessageFormatter.class);
		greeter = new Greeter(mockFormatter);
	}
	
	@Test
	public void testTransform(){
		
		// Arrange
		// mock message mockFormatter
		String inputMsg = "Hello";
		String outputMsg = "HeLlO";
		
		// sets up/registers expectations on the mock
		expect(mockFormatter.transform(inputMsg)).andReturn(outputMsg);
		// activates mock
		replay(mockFormatter);
		
		// Act
		String expectedMessage = greeter.greet(inputMsg);
		// check that it returns the expected value
		assertTrue(expectedMessage.equals(outputMsg));
		
		// ensure the methods we were expecting to invoke are invoked
		verify(mockFormatter);
	}
	
	@Test
	public void testSendEmail(){
		// mock for void method
		expect(mockFormatter.sendEmail("testtest.com", "This is a message"));
		expectLastCall();
		verify(mockFormatter);
		
		
	}

	
}