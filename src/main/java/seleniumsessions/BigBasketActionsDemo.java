package seleniumsessions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketActionsDemo {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		By address_category = By.xpath("(//span[text()='Category'])[2]");
		By beverages = By.xpath("(//a[text()='Beverages'])[2]");
		By address_tea = By.xpath("//a[text()='Tea']");
		By address_greenTea = By.xpath("//a[text()='Green Tea']");
		
		ArrayList<By> listOfElements = new ArrayList<By>();
		listOfElements.add(beverages);
		listOfElements.add(address_tea);
		listOfElements.add(address_greenTea);
		
		
//		driver.findElement(address_category).click();
//
//		Thread.sleep(5000);
//
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(beverages)).perform();
//		Thread.sleep(4000);
//		act.moveToElement(driver.findElement(address_tea)).build().perform();
//		Thread.sleep(4000);
//		act.moveToElement(driver.findElement(address_greenTea)).click().build().perform();
		multiMenuHandle(address_category,listOfElements );
	}

	public static void multiMenuHandle(By parentLocator, ArrayList<By> numberOfChildLocators)
			throws InterruptedException {

		Actions act = new Actions(driver);
		driver.findElement(parentLocator).click();
		Thread.sleep(4000);

		for (int i = 0; i < numberOfChildLocators.size(); i++) {
			WebElement elmnt = driver.findElement(numberOfChildLocators.get(i));
			if (i != numberOfChildLocators.size() - 1) {
				act.moveToElement(elmnt).build().perform();
				Thread.sleep(3000);
				continue;
			}
			act.moveToElement(elmnt).click().build().perform();
		}

	}
}
