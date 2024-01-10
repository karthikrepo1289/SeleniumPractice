package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJSPopupHandling {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		WebElement JSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		JSAlert.click();

		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		Thread.sleep(5000);
		a.accept();

		//Driver is back to page
		WebElement confirmationPopup = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		
		//Switch to alert
		confirmationPopup.click();
		a = driver.switchTo().alert();
		Thread.sleep(5000);
		a.dismiss();
		
		//Driver is back to page
		WebElement promptWindow = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		promptWindow.click();
		
		a = driver.switchTo().alert();
		a.sendKeys("Karthik");
		Thread.sleep(5000);
		a.accept();
		
	}

}
