package seleniumsessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class FluentWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("");

		//(input) = On which instance we have to apply fluent wait.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("Time Out is completed and No Element found")
				.ignoring(NoSuchElementException.class);
	
		//FluentWait implements Wait
		//WebDriverWait extends FluentWait
		//WebDriverWait with FluenntWait features
		FluentWait<WebDriver> waits = new WebDriverWait(driver, Duration.ofSeconds(10))
				              .pollingEvery(Duration.ofSeconds(2))
				              .withMessage("Time Out is done")
				              .ignoring(NoSuchElementException.class, TimeoutException.class);
		waits.until(ExpectedConditions.invisibilityOfElementLocated(By.id("")));
	}

}
