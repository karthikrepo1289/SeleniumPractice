package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// Approach 1 : Create WebElement and Perform action
		// Drawback : Everytime it sends a separate request to server whenever we
		// perform any action on this particular element
		driver.findElement(By.id("input-email")).sendKeys("Karthik");

		// Approach 2 : Get the element first and perform the operation
		WebElement email_Id = driver.findElement(By.id("input-email"));
		email_Id.sendKeys("Approach 2");

		// Approach 3 :
		By emailID = By.id("input-email");
		WebElement e = driver.findElement(emailID);
		e.sendKeys("Approach 3");

		// Approach 4 : By locator and generic method
		WebElement elmntID = getElement(emailID);
		elmntID.sendKeys("Approach 4");

		// Approach 5 : By locator + generic method + action.
		typeDetails(emailID, "Approach 5");

		// Approach 6 : By locator + generic method in a separate util class
		By pwd = By.id("input-password");
		ElementUtility elmnt = new ElementUtility(driver);
		elmnt.doSendKeys(pwd, "My Password");
		
		//Approach 7 : Browser Util + Element Util
		
		//Approach 8 : By -- String
		
		//Approach 9 : POM + Framework
	}

	public static WebElement getElement(By locator) {
		WebElement elmnt = driver.findElement(locator);
		return elmnt;
	}

	public static void typeDetails(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

}
