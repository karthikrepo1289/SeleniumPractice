package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AttributeConcept {
	static By firstName = By.id("input-firstname");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtility br = new BrowserUtility();
		WebDriver driver = br.launchBrowser("chrome");
		br.navigateToPage("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		ElementUtility elmnt = new ElementUtility(driver);
		elmnt.doSendKeys(firstName, "karthik");
		
		//Getting the value that entered in text box during runtime. (value attribute)
		String valueThatEntered = elmnt.doGetAttribute(firstName, "value");
		System.out.println("Value entered in first  name is "+valueThatEntered);
		
		br.closeWindow();
	}

}
