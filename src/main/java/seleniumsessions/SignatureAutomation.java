package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SignatureAutomation {

	static By address_canvas = By.id("signature-pad");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://signature-generator.com/draw-signature/");
		WebElement elmnt = driver.findElement(address_canvas);
		Thread.sleep(6000);

		Actions act = new Actions(driver);
		act.click(elmnt).moveToElement(elmnt,30,10).
		clickAndHold(elmnt).
		moveByOffset(50, 60).build().perform();

	}

}
