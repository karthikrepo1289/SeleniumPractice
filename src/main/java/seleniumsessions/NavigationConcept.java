package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Selenium Manager checks for respective chrome driver from .cache and if it is present it start creating a session by sending a request to chromedriver.
		WebDriver driver = new ChromeDriver();
		System.out.println(((ChromeDriver)driver).getSessionId());
		
		//Navigate to google
		driver.navigate().to("https://www.google.com");
		System.out.println("Title of webpage is "+driver.getTitle());
		driver.navigate().back();
		
		//Navigate to amazon
		driver.navigate().to("https://www.amazon.com");
		System.out.println("Title of webpage is "+ driver.getTitle());
		driver.navigate().back();
		System.out.println("Title of Webpage is "+ driver.getTitle());
		
		//Forward
		driver.navigate().forward();
		System.out.println("Webpage title is "+ driver.getTitle());
		driver.navigate().refresh();
		driver.quit();
		
	}

}
