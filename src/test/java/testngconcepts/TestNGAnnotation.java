package testngconcepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {

//	BS -- Connect with DB
//	BT -- Create User
//	BC -- Launch Browser
	
		/*BM -- Log into App
		add to cart Test
		AM - Logout*/
	
		/*BM -- Log into App
		Checkout Test
		AM - Logout*/
	
		/*BM -- Log into App
		Search Test
		AM - Logout*/
	
//	AC - Close Browser
//	AT - Delete Use
//	AS - Disconnect DB
	
	@BeforeSuite
	public void connectDB() {
		System.out.println("BS -- Connect with DB");
	}

	@BeforeTest
	public void createUser() {
		System.out.println("BT -- Create User");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -- Launch Browser");
	}

	@BeforeMethod
	public void logintoApp() {
		System.out.println("BM -- Log into App");
	}

	@Test
	public void searchTest() {
		System.out.println("Search Test");
	}

	@Test
	public void addToCartTest() {
		System.out.println("add to cart Test");
	}

	@Test
	public void checkOutTest() {
		System.out.println("Checkout Test");
	}

	@AfterMethod
	public void logOut() {
		System.out.println("AM - Logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC - Close Browser");
	}

	@AfterTest
	public void deleteUser() {
		System.out.println("AT - Delete User");
	}

	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS - Disconnect from Data Base");
	}
}
