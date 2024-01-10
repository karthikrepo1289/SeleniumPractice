package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Assignment_WebTable_Switch {

	static WebDriver driver;
	static By address_username = By.cssSelector("input[name='username']");
	static By address_password = By.cssSelector("input[name='password']");
	static By address_button = By.cssSelector("input[value='Login']");
	static By address_contact = By.linkText("CONTACTS");
	static By addreess_NewContact = By.linkText("New Contact");
	static By address_company = By.xpath("//input[@name='client_lookup']");
	static By address_search = By.id("search");
	static By address_search_button = By.xpath("//input[@value='Search']");
	static By address_search_link = By.linkText("ABCD");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");

		driver.findElement(address_username).sendKeys("apiautomation");
		driver.findElement(address_password).sendKeys("selenium@12345");
		driver.findElement(address_button).click();
		Thread.sleep(4000);

		String parentWindowHandle = driver.getWindowHandle();
		driver.switchTo().frame("mainpanel");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(address_contact)).build().perform();
		driver.findElement(addreess_NewContact).click();
		driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(address_company)).click();
		driver.switchTo().defaultContent();

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();

		while (iterator.hasNext()) {
			String tempHandle = iterator.next();
			if (tempHandle.equals(parentWindowHandle)) {
				continue;
			}else {
				driver.switchTo().window(tempHandle);
			}
		}
		
		driver.findElement(address_search).sendKeys("ABC");
		driver.findElement(address_search_button).click();
		driver.findElement(address_search_link).click();
		
		driver.switchTo().window(parentWindowHandle);

	}

}
