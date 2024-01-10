package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadow_Dom_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");

		// Shadow Dom Element : #Shadow-Root (Open)
		String jsScript = "return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get the html element using java script and Convert it to Selenium WebElement
		// to perform actions.
		WebElement elmnt = (WebElement) js.executeScript(jsScript);
		elmnt.sendKeys("Rich Dad Poor Dad");
	}

}

/**
a. Find the element using CSS Selector (Inspect Element --> Copy JS Path)
b. Execute the java script using JavascriptExecutor which returns html element
c. Convert that html element to WebElement and performs the actions.
*/
