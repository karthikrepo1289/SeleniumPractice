package testngconcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/");
	}

	// TC1 :
	@Test(priority = 1)
	public void openCartURLTest() {
		String expected = "https://naveenautomationlabs.com/opencart/";
		String actTitle = driver.getCurrentUrl();

		// Check actual url matches with expected
		Assert.assertEquals(actTitle, expected);
	}

	// TC 2
	@Test(priority = 2)
	public void openCartTitleTest() {
		String expectedTitle = "Your Store";
		String actTitle = driver.getTitle();

		Assert.assertEquals(actTitle, expectedTitle);
	}

	// TC 3
	@Test(priority = 3)
	public void isSearchButtonEnableTest() {
		boolean isSearchButtonEnabled = driver.findElement(By.xpath("//div[@id='search']//button")).isEnabled();
		Assert.assertTrue(isSearchButtonEnabled);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
