package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElementHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("chrome://history/");

		// #shadow-root (open)
		// Can't handle using xpath
		// Inspect the element->Copy its js path
		String jsPath = "return document.querySelector(\"#history-app\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#mainToolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Converting html element to Selenium WebElement
		WebElement inputBox = (WebElement) js.executeScript(jsPath);
		inputBox.sendKeys("test");
	}

}
