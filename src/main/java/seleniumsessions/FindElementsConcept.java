package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=cms/demo");

		// Requirement : Find total links present on a page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());

		List<String> listOfTitles = new ArrayList<String>();
		for (int i = 0; i < links.size(); i++) {
			WebElement lnk = links.get(i);
			
				System.out.println(lnk.getAttribute("href"));
				listOfTitles.add(lnk.getAttribute("href"));
			
		}

		// Wait
		Thread.sleep(3000);

		// Close the window
		driver.close();
	}

}
