package testngconcepts;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	static int i =1;

	@Test(invocationCount = 10)
	public void searchPerformanceTest() {
		System.out.println("Performance testing "+i);
		i++;
	}

}
