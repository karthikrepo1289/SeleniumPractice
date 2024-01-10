package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Google_Language_Links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		By links = By.xpath("//div[@id='SIvCob']/a");
		
		BrowserUtility br = new BrowserUtility();
		WebDriver driver = br.launchBrowser("chrome");
		br.navigateToPage("https://www.google.com");
		
		List<WebElement> lngsLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		for(WebElement elmnt : lngsLinks) {
			System.out.println(elmnt.getText());
			
			if(elmnt.getText().contains("తెలుగు")) {
				elmnt.click();
				break;
			}
		}
	}
	
	

}
