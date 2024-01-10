package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	static By address_slider = By.id("slider");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");

		WebElement slider = driver.findElement(address_slider);
		int x = slider.getLocation().getX();
		int y = slider.getLocation().getY();
		int height = slider.getSize().getHeight();
		int width = slider.getSize().getWidth();
		
		System.out.println("Location is "+"x ="+x+" y ="+y);
		System.out.println("Size is "+"height ="+height+" width ="+width);
		Thread.sleep(6000);

		Actions act = new Actions(driver);
		act.clickAndHold(slider).moveByOffset(x+100,0).build().perform();
		driver.close();
		
	}

}
