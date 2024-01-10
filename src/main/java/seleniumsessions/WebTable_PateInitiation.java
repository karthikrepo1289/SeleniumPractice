package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_PateInitiation {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		String country = "India";
		Thread.sleep(5000);

		// Use Case 1 : Single Selection
		By address = By.xpath("//td[text()='" + country + "']");
		By address_nextbutton = By.linkText("Next");

//		while (true) {
//			if (driver.findElements(address).size() >= 1) {
//				selectCountry(country);
//				break;
//			} else {
//				WebElement nxtButton = driver.findElement(address_nextbutton);
//				if (!nxtButton.getAttribute("class").equals("paginate_button next disabled")) {
//					nxtButton.click();
//					Thread.sleep(1000);
//				} else {
//					System.out.println("Given Country not found");
//					break;
//				}
//			}
//		}
//
//		WebElement nxtButton = driver.findElement(address_nextbutton);
		// Use Case 2 : Select each page and select the checkbox associated to country
		while (true) {
			
			if (!(driver.findElement(address_nextbutton).getAttribute("class")
					.equals("paginate_button next disabled"))) {
				selectMultipleCountry(country);
				driver.findElement(address_nextbutton).click();
				Thread.sleep(2000);
			} else {
				selectMultipleCountry(country);
				break;
			}
		}
	}

	public static void selectMultipleCountry(String country) {
		List<WebElement> elmnts = driver.findElements(
				By.xpath("//td[text()='" + country + "']" + "//preceding-sibling::td/input[@type='checkbox']"));

		for (int i = 0; i < elmnts.size(); i++) {
			elmnts.get(i).click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void selectCountry(String country) {
		driver.findElement(
				By.xpath("//td[text()='" + country + "']" + "//preceding-sibling::td/input[@type='checkbox']")).click();
	}
}
