package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserHandleMultipleWindows {

	// Declaration
	public static WebDriver driver;

	// Get the address of all the elements you want to work on the page.
	static By address_linkedin = By.xpath("//a[contains(@href,'linkedin')]");
	static By address_facebook = By.xpath("//a[contains(@href,'facebook')]");
	static By address_twitter = By.xpath("//a[contains(@href,'twitter')]");
	static By address_youtube = By.xpath("//a[contains(@href,'youtube')]");

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub
		driver = new ChromeDriver();

		// Navigate to Application
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Wait 3 sec for the page to load and elements to locate
		Thread.sleep(3000);

		// Get the parent window id
		String parentWindowID = driver.getWindowHandle();

		// Click on the footer links
		driver.findElement(address_facebook).click();
		driver.findElement(address_linkedin).click();
		driver.findElement(address_youtube).click();
		driver.findElement(address_twitter).click();

		// Requirement : Switch to each window and get the url.

		// Step 1 : Collect the window id's
		Set<String> windowHandles = driver.getWindowHandles();

		// Step 2 : To Fetch each id from set collection.
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()) { // Checks next element present in the collection or not
			String handle = iterator.next(); // Returns the next element in the iteration.

			// Switch the driver to particular window
			driver.switchTo().window(handle);
			// Get the current window url
			System.out.println(driver.getCurrentUrl());
			// Wait for 4 Sec
			Thread.sleep(4000);
			// Close the current browser only if it is not a parent browser.
			if (!handle.equals(parentWindowID)) {
				driver.close();
			}
			// Control goes back to loop and checks is next element present in the
			// collection.
		}

		// At this step, All the child windows are closed except parent window. driver
		// has no clue
		// We must tell the driver to switch to parent window before proceeding any
		// actions on main window.
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();

	}

}
