package testngconcepts;

import org.testng.annotations.Test;

public class DependencyConcept {

	@Test
	public void loginTest() {
		System.out.println("Login Test");
	//	int a = 10/0;
	}

	@Test(dependsOnMethods = "loginTest")
	public void searchPageTest() {
		System.out.println("Search Test");
	}

	@Test(dependsOnMethods = "searchPageTest")
	public void addToCartTest() {
		System.out.println("Add To Cart Test");
	}
}
