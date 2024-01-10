package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeys_Disabled_Element {

	static WebDriver driver;
	static By address_disable_button = By.xpath("//button[contains(text(),'Disable')]");
	static By address_textbox = By.id("myText");

	// https://www.w3schools.com/jsreF/tryit.asp?filename=tryjsref_text_disabled2
	// iframeResult
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsreF/tryit.asp?filename=tryjsref_text_disabled2");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		try {
			driver.findElement(address_textbox).sendKeys(null);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		try {
			driver.findElement(address_disable_button).click();
		}catch(ElementNotInteractableException e) {
			System.out.println(e.getMessage());
		}
	}

}
