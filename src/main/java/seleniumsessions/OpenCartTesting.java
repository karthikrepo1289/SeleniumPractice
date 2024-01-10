package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 10/16/2023 Class that demonstrates the using of BrowserUtil and ElementUtil
 * classes.
 */
public class OpenCartTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtility br = new BrowserUtility();
		WebDriver driver = br.launchBrowser("chrome");
		br.navigateToPage("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(br.getPageTitle());
		
		//Enter User Name : a. Identify Element b. Perform Actions.
		By email_ID = By.id("input-email");
		By pwd = By.id("input-password");
		
		//Create Element Utility Instance
		ElementUtility elmnt = new ElementUtility(driver);
		elmnt.doSendKeys(email_ID, "karthik@gmail.com");
		elmnt.doSendKeys(pwd, "demo");
		
		//Close the browser
		br.closeWindow();
	}

}
