package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketActionsDemoPartTwo {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);

		By address_parentMenu = By.xpath("(//span[text()='Shop by'])[2]");
		By address_childMenuOne = By.xpath("//div[@role='menu']//ul[1]/li");
		By address_subChildMenu = By.xpath("//div[@role='menu']//ul[2]/li");
		By address_grandChildMenu = By.xpath("//div[@role='menu']//ul[3]/li");

		driver.findElement(address_parentMenu).click();
		List<WebElement> childMenuItems = driver.findElements(address_childMenuOne);
		List<WebElement> subChildMenu;
		List<WebElement> grandSubChildMenu;
		// int size = childMenuItems.size()/2;

		for (int i = 0; i < childMenuItems.size(); i++) {
			WebElement elmnt = childMenuItems.get(i);

			if (elmnt.getText().length() != 0) {
				System.out.println(elmnt.getText());
				act.moveToElement(elmnt).build().perform();
				Thread.sleep(2000);
				subChildMenu = driver.findElements(address_subChildMenu);
				System.out.println(subChildMenu.size());

				for (int j = 0; j < subChildMenu.size(); j++) {

					WebElement subElement = subChildMenu.get(j);

					if (subElement.getText().length() != 0) {
						System.out.println(subElement.getText());
						act.moveToElement(subElement).build().perform();
						Thread.sleep(2000);

						grandSubChildMenu = driver.findElements(address_grandChildMenu);
						WebElement grandSubChild;

						for (int k = 0; k < grandSubChildMenu.size(); k++) {
							grandSubChild = grandSubChildMenu.get(k);
							if (grandSubChild.getText().length() != 0) {
								System.out.println(grandSubChild.getText());
							}
						}
					}
				}
				Thread.sleep(1000);
			}

		}

	}

}
