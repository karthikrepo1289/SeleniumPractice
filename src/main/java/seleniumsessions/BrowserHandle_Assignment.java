package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserHandle_Assignment {

	static WebDriver driver;
	static By address_youtube = By.xpath("//a[contains(@href,'youtube')]");
	static By address_facebook = By.xpath("//a[contains(@href,'facebook')]");
	static By address_twitter = By.xpath("//a[contains(@href,'twitter')]");
	static By address_linkedin = By.xpath("//a[contains(@href,'linkedin')]");
	static String childWindowID;
	static Set<String> handlers;
	static String parentWindowID;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		parentWindowID = driver.getWindowHandle();
		System.out.println(parentWindowID);
		
		driver.findElement(address_facebook).click();
		iterateAndClose();
		
		driver.findElement(address_linkedin).click();
		iterateAndClose();
		
		driver.findElement(address_youtube).click();
		iterateAndClose();
		
		driver.findElement(address_twitter).click();
		iterateAndClose();
		
		System.out.println(driver.getTitle());
		driver.quit();
		
		

	}
	
	public static void iterateAndClose() throws InterruptedException {
		handlers = driver.getWindowHandles();
		
		Iterator<String> iterator = handlers.iterator();
		while(iterator.hasNext()) {
			String text = iterator.next();
			System.out.println(text);
			
			if(!text.equals(parentWindowID)) {
				driver.switchTo().window(text);
				Thread.sleep(3000);
				driver.close();
			}		
		}
		//Go back to main window and click other link and perform the same operation as above.
		driver.switchTo().window(parentWindowID);
	}

}

/*
 * Launch Orange HRM Browser Click on Facebook Page footer link and Get its page
 * url Close the Window Click on Youtube Page footer link and Get its page url
 * Close the Window Click on Twitter footer link and Get its page url Close the
 * Window Click on Youtube footer link and Get its page url Close the Window Get
 * the Main Window Title Close the Window.
 */
