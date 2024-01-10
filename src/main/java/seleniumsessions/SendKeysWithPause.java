package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause {

	public static WebDriver driver;
	public static By locator = By.xpath(" //input[@name='search']");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		doActionSendKeysWithPause(locator, "Trinath");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionSendKeysWithPause(By location, String value) {

		WebElement elmnt = getElement(location);
		Actions act = new Actions(driver);
		char[] vals = value.toCharArray();

		for (int i = 0; i < vals.length; i++) {
			act.sendKeys(elmnt, String.valueOf(vals[i])).pause(500).build().perform();
		}
	}
}
