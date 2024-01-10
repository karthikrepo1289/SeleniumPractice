package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCart_Register {

	static By firstName = By.id("input-firstname");
	static By lastName = By.id("input-lastname");
	static By email = By.id("input-email");
	static By telephone = By.id("input-telephone");
	static By password = By.id("input-password");
	static By confirmPassword = By.id("input-confirm");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//

		BrowserUtility br = new BrowserUtility();
		
		//ChromeDriver launched and connect established with a session id
		WebDriver driver = br.launchBrowser("chrome");

		// Navigate to application
		br.navigateToPage("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// Now find the elements and send the keys.
		ElementUtility elmnts = new ElementUtility(driver);
		elmnts.doSendKeys(firstName, "My FirstName");
		elmnts.doSendKeys(lastName, "My LastName");
		elmnts.doSendKeys(email, "ka@gmail.com");
		elmnts.doSendKeys(telephone, "8898731290");
		elmnts.doSendKeys(password, "test@123");
		elmnts.doSendKeys(confirmPassword, "test@123");
		
		
		//Close Browser
	}

}
