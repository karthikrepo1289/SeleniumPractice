package seleniumsessions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Fill the registration form using only one webelement
 */

public class ActionsSendKeysWithOutFindElement {

	public static WebDriver driver;
	public static By firstName = By.id("input-firstname");
	public static By allElement = By.xpath("//form[@class='form-horizontal']//input[contains(@id,'input')]");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement elmnt = driver.findElement(firstName);
		int size = driver.findElements(allElement).size();
		elmnt.sendKeys("Karthik");
		Actions act = new Actions(driver);
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Karthik");
		arr.add("Thammishetty");
		arr.add("karthiktest@gmail.com");
		arr.add("4478292929");
		arr.add("test@test");
		arr.add("test@test");
		

		for (int i = 0; i < size; i++) {
			act.sendKeys(Keys.TAB).pause(500).build().perform();
			act.sendKeys(arr.get(i)).build().perform();
		}

	}

}
