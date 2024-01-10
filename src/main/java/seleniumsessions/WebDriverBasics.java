package seleniumsessions;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the browser you want to select");
		String browser = new Scanner(System.in).nextLine();

		//Cross Browser + Parallel Testing = Object Creation with top casting
		switch (browser.toLowerCase().trim()) {

		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			throw new AutomationException("Please chose the right browser");
		}

		driver.get("https://www.google.com");

		// 3. Get title (Tab Name)
		String actTitle = driver.getTitle();
		System.out.println("Title of a webpage is " + actTitle);

		// 4. Verify the title. Checkpoint/Verification Point
		if (actTitle.equals("Google"))
			System.out.println("Title is displayed as expected. -- PASS");
		else
			System.out.println("Title not matched -- FAIL");

		// 5. Close the Browser
		driver.close();
	}

}
