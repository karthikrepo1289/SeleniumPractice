package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtility {

	/**
	 * Hiding this from ourside of the class. Because if we make it public we can
	 * instantinate this class and accessing the driver directly where it returns
	 * null
	 */
	private WebDriver driver;

	/**
	 * Utility method to launch the desired browser
	 * 
	 * @param browserType
	 * @return Instance of WebDriver
	 */
	public WebDriver launchBrowser(String browserType) {

		if (!(browserType == null)) {

			switch (browserType.toLowerCase().trim()) {
			case "chrome":
				driver = new ChromeDriver();
				break;

			case "firefox":
				driver = new ChromeDriver();
				break;

			case "safari":
				driver = new SafariDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				throw new AutomationException("Please select a valid browser");
			}
		} else {
			throw new AutomationException("Please pass browser type");
		}

		return driver;
	}

	/**
	 * Utility method to navigate to particular page
	 * 
	 * @param url
	 */
	public void navigateToPage(String url) {

		if (url != null && url.indexOf("http") == 0 && driver != null && url.contains("://")) {
			driver.get(url);
		} else {
			if (driver == null) {
				throw new AutomationException("WebDriver is not insantiated");
			}
			throw new AutomationException("Please pass the valid url format");
		}
	}

	/**
	 * Utility method to get the page title
	 * 
	 * @return String
	 */
	public String getPageTitle() {
		String title;

		if (driver != null) {
			title = driver.getTitle();
			System.out.println("Webpage title is " + title);
		} else {
			throw new AutomationException("WebDriver is not instantiated");
		}
		return title;
	}

	/**
	 * Utility method to get page source
	 * 
	 * @return boolean
	 */
	public boolean getCurrentPageSource(String key) {
		boolean isKeyContain;

		if (driver != null) {
			isKeyContain = driver.getPageSource().contains(key);
		} else {
			throw new AutomationException("WebDriver is not instantiated");
		}
		return isKeyContain;
	}

	/**
	 * Utility method to close the browser
	 */
	public void closeWindow() {

		driver.close();
		//System.out.println("Browser is closed. ");
	}

	/**
	 * Utility method to find the current url
	 */

	public String getCurrentPageUL() {

		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is " + currentURL);
		return currentURL;
	}
	
	
}
