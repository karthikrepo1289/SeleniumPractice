package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_BrowserWindow {
	static By address_linkedin = By.xpath("//a[contains(@href,'linkedin')]");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		String parentWidowHandle = driver.getWindowHandle();

		driver.findElement(address_linkedin).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean res = wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		try {
			if (res) {
				System.out.println("Linkedin Window is opened");
			}
		} catch (TimeoutException e) {
			System.out.println(e.getMessage());
			System.out.println("Linkedin window is not opened");
		}

	}

}
