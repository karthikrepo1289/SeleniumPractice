package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {

		// Local Machine. Can run only specific browser.
		ChromeDriver driver = new ChromeDriver();

		// Top Casting, valid and recommended. 
		// Recommended whenever we want to execute our test case in our local machine
		WebDriver recom = new ChromeDriver();
		
		//Top Casting, valid and Not recommended
		//Reason : Only methods present inside search context are findelement and findelments
		SearchContext parentInterface = new ChromeDriver();
		//parentInterface.get(" ")
		
		//Top Casting, valid and Not Recommended.
		//Reason : If any new browser in market and  in future directly implements WebDriver interface.
		RemoteWebDriver prnt = new ChromeDriver();
		
		
		//Top Casting. Valid and Recommended. To run tests on grid / remote machine / cloud
		//WebDriver rm = new RemoteWebDriver(null, null)
		
		//Valid and Not recommended. because we can use it only for chrome and edge.
		ChromiumDriver dr = new ChromeDriver();
		
	}

}
