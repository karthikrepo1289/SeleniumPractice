package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicityWait_WaitForAlert {
	static By address_jsButton = By.xpath("//button[text()='Click for JS Alert']");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		// Click on JS button
		driver.findElement(address_jsButton).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// If alert is present then alertIsPresent returns driver.switchTo().alert() :
		// Alert
		// Else it returns null
		Alert a = wait.until(ExpectedConditions.alertIsPresent());
		if (a != null) {
			a.accept();
		}
	}

	
}
