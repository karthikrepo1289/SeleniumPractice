package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		By address_rightClick = By.xpath("//span[contains(text(),'right click')]");
		By subMenu_address = By.cssSelector("li.context-menu-icon>span");
		rightClick(address_rightClick, "Copy", subMenu_address);

	}

	public static void rightClick(By ElmentToRightClick, String optionToPass, By subMenuAddress) {
		Actions act = new Actions(driver);
		WebElement righClick = driver.findElement(ElmentToRightClick);
		act.contextClick(righClick).build().perform();
		List<WebElement> options = driver.findElements(subMenuAddress);
		
		for (WebElement option : options) {

			if (option.getText().equals(optionToPass)) {
				option.click();
				break;
			}
		}

	}
}
