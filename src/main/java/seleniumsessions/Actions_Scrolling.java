package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Scrolling {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		Actions act = new Actions(driver);

		// Scrolling Down (Scrolls Little Down)
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
		// Scrolling Up (Scrolls Little Up)
		act.sendKeys(Keys.PAGE_UP).build().perform();

		// Complete Scroll Down
		act.sendKeys(Keys.END).build().perform();
		Thread.sleep(5000);

		// Complete Scroll Up
		act.sendKeys(Keys.HOME).build().perform();
		Thread.sleep(6000);

		// Scroll To Particular Element and Click
		WebElement elmnt = driver.findElement(By.linkText("Twitter"));
		act.scrollToElement(elmnt).click(elmnt).build().perform();
		Thread.sleep(5000);
		
		/*act.scrollToElement(elmnt).build().perform();
		Thread.sleep(5000);
		act.click(elmnt).build().perform();*/
		
		//Refresh the page
		act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.COMMAND).build().perform();
	}

}
