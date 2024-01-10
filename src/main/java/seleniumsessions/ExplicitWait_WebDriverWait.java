package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class ExplicitWait_WebDriverWait {

	static WebDriver driver;
	static By address_email = By.id("input-email");
	static By address_pwd = By.id("input-password");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// Step 1 : Instantiate WebDriverWait by passing driver and number of seconds that script to wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Prepare the expected conditions.
		//WebDriver wait for this element for 10 seconds. If element is find in dom with in 10 sec the remaining time will be ignored.
		//With in the specified time, If element is not present in dom then we will get NoSuchElement + TimeOutException
		WebElement userID = wait.until(ExpectedConditions.presenceOfElementLocated(address_email));
		userID.sendKeys("hello@gmail.com");
		
		//a. visibilityOfElementLocated find the element present in the dom or not and it is visible on the page or not. (i.e height and widdth >0)
		WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(address_pwd));
		pwd.sendKeys("testing");
		
		;
	}

}
