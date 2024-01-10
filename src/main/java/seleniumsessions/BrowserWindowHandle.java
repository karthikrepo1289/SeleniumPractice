package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandle {

	public static WebDriver driver;
	static By address_twitter = By.xpath("//a[contains(@href,'twitter')]");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		driver.findElement(address_twitter).click();

		// Set object doesn't allow duplicate objects and objects not stored in the
		// sequence
		// Collect the handle id's of all active windows / tab
		Set<String> windowHandles = driver.getWindowHandles();

		// iterator() helps to fetch the values from non order based collection.
		Iterator<String> iterate = windowHandles.iterator();
		
		String parentWindowHandle = iterate.next();
		System.out.println("Parent Window Handle is " +parentWindowHandle);

		String childWindowHandle = iterate.next();
		System.out.println("Child Window Handle is " +childWindowHandle);
		
		driver.switchTo().window(childWindowHandle);
		System.out.println(driver.getCurrentUrl());
		driver.close(); //Current / Child window is closed.
		
		//Where is the driver ? driver is no where or driver is lost. We have to come back to parent window
		
		Thread.sleep(4000);
		
		//We must switch back to parent window
		driver.switchTo().window(parentWindowHandle);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}
