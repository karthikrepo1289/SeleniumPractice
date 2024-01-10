package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		By drag = By.id("draggable");
		By drop = By.id("droppable");

		WebElement draggable = driver.findElement(drag);
		WebElement droppable = driver.findElement(drop);

		Actions act = new Actions(driver);
		//act.dragAndDrop(draggable, droppable).build().perform();
		act
			.clickAndHold(draggable)
				.moveToElement(droppable)
						.release(droppable)
									.build()
										.perform();

	}

}
