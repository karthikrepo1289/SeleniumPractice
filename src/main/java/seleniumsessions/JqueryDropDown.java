package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectmenu/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		driver.findElement(By.xpath("//span[@id='speed-button']")).click();
		Thread.sleep(5000);
		By locator = By.xpath("//ul[@id='speed-menu']/li");
		selectValuesFromNonSelectDropdown(locator, "Fast");
	}

	public static void selectValuesFromNonSelectDropdown(By locator, String valueToSelect) {
		
		List<WebElement> vals = driver.findElements(locator);
		for(WebElement val : vals) {
			String text = val.getText();
			if(text.equals(valueToSelect)) {
				val.click();
				break;
			}
		}
		
	}
}
