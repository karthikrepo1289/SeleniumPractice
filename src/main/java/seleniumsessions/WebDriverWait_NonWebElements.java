package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.TimeoutExceededException;

public class WebDriverWait_NonWebElements {
	static By address_aboutLink = By.linkText("About Us");
	static By address_title = By.xpath("//h1[text()='About Us']");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// Click on About Us link
		driver.findElement(address_aboutLink).click();

		// Validate Title
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		try {
		if(wait.until(ExpectedConditions.titleContains("About Us"))){
			System.out.println(driver.getTitle());
		}else {
			System.out.println("Title value is not matched");
		}}catch(TimeoutExceededException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
