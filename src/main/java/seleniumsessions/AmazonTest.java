package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class AmazonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowserUtility br = new BrowserUtility();
		WebDriver driver = br.launchBrowser("chrome");

		// Navigate to a page.
		br.navigateToPage("http://www.amazon.com");

		//Validate page title.
		if(br.getPageTitle().contains("Amazon")) {
			System.out.println("Launched the amazon page -- PASS");
		}else {
			System.out.println("Expected page is not launched");
		}
		
		//Validate current url
		if(br.getCurrentPageUL().contains("amazon")) {
			System.out.println("URL Validation sucess --PASS");
		}else {
			System.out.println("URL Mismatch ");
		}
		
		//Close the browser
		br.closeWindow();
	}

}
