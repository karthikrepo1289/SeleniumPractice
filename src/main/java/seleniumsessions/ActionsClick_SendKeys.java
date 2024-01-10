package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClick_SendKeys {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		Actions act = new Actions(driver);
		By email_address = By.id("input-email");
		By password_address = By.id("input-password");
		By login_address = By.xpath("//input[@value='Login']");
		//act.click(loginButton).build().perform(); // Equivalent to act.moveToElement(WebElement).click();
		doActionSendKeys(email_address, "karthhik");
		doActionSendKeys(password_address, "Karthik");
		doActionClick(login_address);
	}
	

	public static WebElement getElement(By location) {
		return driver.findElement(location);
	}
	
	public static void doActionSendKeys(By elementAddress, String valueToPass) {
		Actions act = new Actions(driver);
		WebElement val = getElement(elementAddress);
		act.sendKeys(val, valueToPass).build().perform();
	}
	
	public static void doActionClick(By elementToClick) {
		Actions act = new Actions(driver);
		WebElement elmnt = getElement(elementToClick);
		act.click(elmnt).build().perform();
		
	}
}
