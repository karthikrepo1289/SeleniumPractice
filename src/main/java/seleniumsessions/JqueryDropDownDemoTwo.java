package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownDemoTwo {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
		By locator = By.id("justAnInputBox");
		driver.findElement(locator).click();
		Thread.sleep(5000);
		
		By options = By.xpath("//span[@class='comboTreeItemTitle']");
		selectValueFromNonSelect(options, "choice 4");
		
	}
	
	public static void selectValueFromNonSelect(By locator, String value)
	{
		List<WebElement> lstOptions = driver.findElements(locator);
		
		for(WebElement option : lstOptions) {
			String text = option.getText();
			if(text.equals(value)) {
				option.click();
				break;
			}
		}
	}
	
	public static void selectMultiValuesFromNonSelect(By locator, String... value)
	{
		List<WebElement> lstOptions = driver.findElements(locator);
		
		if(value.length==1 && value[0].equalsIgnoreCase("all")) {
			for(WebElement option : lstOptions) {
				try {
				option.click();}
				catch(ElementNotInteractableException e) {
					
				}
			}
		}
	}
}
