package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

	static WebDriver driver;
	static By logo = By.xpath("//img[contains(@src,'OrageHRM')]");

	// Implementation of our own dynamic wait
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		WebElement elmnt = retryingElement(logo, 5);
		System.out.println(elmnt.getAttribute("src"));
	}

	public static WebElement retryingElement(By locator, int timeOut) {
		WebElement elmnt = null;
		int numberOfAttempts = 0;

		while (numberOfAttempts < timeOut) {
			try {
				elmnt = driver.findElement(locator);
				System.out.println(locator + " Element is found ");
				break;
			} catch (NoSuchElementException exception) {
				System.out.println(locator + " Element is not found" + "Current attempt is " + numberOfAttempts);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			numberOfAttempts++;
		}

		if (elmnt == null) {
			System.out.println(
					"Unable to find the element " + locator + " Number of attempts we made is " + numberOfAttempts);
			throw new AutomationException("Element Not Found");
		}
		return elmnt;
	}

	/*Utility method to find page is loaded or not*/
	public boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = (String) wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
		return Boolean.parseBoolean(flag);
	}
}
