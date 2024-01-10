package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/Books-Udayan-Khattry/s?rh=n%3A976389031%2Cp_27%3AUdayan+Khattry");

		// Address of element.
		By searchTextBoxAddress = By.id("twotabsearchtextbox");
		By locator_links = By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']");
		String elementToSearch = "software testing";

		// Find Element aria-label
		WebElement searchBox = driver.findElement(searchTextBoxAddress);
		searchBox.sendKeys("testing");

		// Wait
		Thread.sleep(4000);

		List<WebElement> lst = driver.findElements(locator_links);
		for(WebElement elmnt : lst) {
			System.out.println(elmnt.getAttribute("aria-label"));
			if(elmnt.getAttribute("arial-label").equalsIgnoreCase("software testing")) {
				elmnt.click();
			}
		}
	}

}
