package testngconcepts;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest() {
		
		System.out.println("Enter invalid credentials");
		System.out.println("Yes it is expected that exception should throw");
		int i = 10/0; 
		System.out.println("This statement doesn't execute as we are not handling the exception");
	}

}
