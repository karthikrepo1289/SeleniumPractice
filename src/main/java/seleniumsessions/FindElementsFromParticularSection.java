package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsFromParticularSection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By elmnts = By.xpath("//div[@class='list-group']/a");
//
//		List<WebElement> links = driver.findElements(elmnts);
//		List<String> titles = new ArrayList<String>();
//		
//		for(WebElement link : links) {
//			titles.add(link.getText());
//		}
//		System.out.println(titles);
		
		BrowserUtility br = new BrowserUtility();
		WebDriver driver = br.launchBrowser("chrome");
		br.navigateToPage("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		ElementUtility elmnt = new ElementUtility(driver);
		List<String> doGetElementsText = elmnt.doGetElementsText(elmnts);
		System.out.println(doGetElementsText);
		
		br.closeWindow();
	}

}
