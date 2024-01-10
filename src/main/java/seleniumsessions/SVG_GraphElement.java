package seleniumsessions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVG_GraphElement {

	static By address_states = By
			.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g']//*[name()='g' and @class='region']");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));

		Thread.sleep(6000);
		List<WebElement> states = driver.findElements(address_states);
		System.out.println(states.size());
		Iterator<WebElement> iterator = states.iterator();
		Actions act = new Actions(driver);
		while (iterator.hasNext()) {
			WebElement state_element = iterator.next();
			act.moveToElement(state_element).build().perform();
			Thread.sleep(400);
			String state = state_element.getAttribute("id");
			//It prints the state
			System.out.println(state);
			if(state.equals("texas")) {
				state_element.click();
				break;
			}
		}
		driver.switchTo().defaultContent();
		driver.close();
	}

}
