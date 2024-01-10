package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElement_Concept {
	
	static By address_searchBox = By.name("q");
	static By svg_address_searchIcon = By.xpath("//button[contains(@title,'Search')]//*[local-name()='svg']");

	public static void main(String[] args) {
		// Scaler Vector Graphic Element
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		//local-name()='svg'
		driver.findElement(address_searchBox).sendKeys("mobiles");
		driver.findElement(svg_address_searchIcon).click();
	}

}
