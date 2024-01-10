package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Element_Enable_Display {

	static By address_submit_button = By.id("submitButton");
	static By address_first_name = By.name("first_name");
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/register/");

		WebElement submit_button = driver.findElement(address_submit_button);
		System.out.println("Is Submit Button Visible ? " + submit_button.isDisplayed());
		System.out.println("Is Submit Button Enabled ? " + submit_button.isEnabled());

		try {
			submit_button.click(); // Exception throws when we click on the disabled button. We don't see this
									// exception when we use action class click method
		} catch (ElementNotInteractableException e) {
			System.out.println(e.getMessage());
		}

		driver.findElement(address_first_name).sendKeys("Hello");
		System.out.println("Is Submit Button Enabled " + submit_button.isEnabled());
	}
}
