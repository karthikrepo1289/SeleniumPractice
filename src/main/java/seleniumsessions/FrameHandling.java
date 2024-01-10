package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(3000);

		/** NoSuchElementException as respective element is present inside a frame **/
//		String txt = driver.findElement(By.xpath("//h2[text()='Title bar ']")).getText();
//		System.out.println("Title is : "+txt);

		// Using Index - Not Recommended.
//		driver.switchTo().frame(2);
//		String txt = driver.findElement(By.xpath("//h2[text()='Title bar ']")).getText();
//		System.out.println("Title is : "+txt);

		// Option 2
		// Using name/id
//		driver.switchTo().frame("main");
//		String txt = driver.findElement(By.xpath("//h2[text()='Title bar ']")).getText();
//		System.out.println("Title is : "+txt);

		// Option 3 - Using WebElement
		WebElement frameElmnt = driver.findElement(By.xpath("//frame[@name='main']"));
		driver.switchTo().frame(frameElmnt);
		String txt = driver.findElement(By.xpath("//h2[text()='Title bar ']")).getText();
		System.out.println("Title is : "+txt);
	}

}
