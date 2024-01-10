package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Headless Browser Testing : No active browser window No active ui Testing is
		 * happending behind the scene Faster than UI mode But might not interact with
		 * some complex applications.
		 * 
		 */

		/*
		 * When to use : CICD | Cloud | AWS | Linux | Jenkins
		 */

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");

		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.orangehrm.com/");
		System.out.println(driver.getTitle());
	}

}
