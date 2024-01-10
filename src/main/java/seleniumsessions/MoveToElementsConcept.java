package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementsConcept {

	static WebDriver driver;
	static By parentMenuAddress = By.cssSelector("a.menulink");
	static By subMenuAddress = By.linkText("COURSES");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search");
		driver.manage().window().maximize();
		parentChildMenu(parentMenuAddress, subMenuAddress);
	}

	public static WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}

	public static void parentChildMenu(By parentMenuAddress, By childMenuAddress) throws InterruptedException {

		Actions act = new Actions(driver);
		WebElement parentMenu = doGetElement(parentMenuAddress);
		act.moveToElement(parentMenu).build().perform();
		Thread.sleep(2000);
		doGetElement(childMenuAddress).click();
	}
}
