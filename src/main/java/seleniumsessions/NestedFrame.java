package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

	public static WebDriver driver;
	public static By address_memory = By.id("inp_val");
	public static By address_dare = By.id("jex");
	public static By address_heaven = By.id("glaf");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/iframe-scenario/");
		
		//Switch from Page to Frame1
		driver.switchTo().frame("pact1");
		driver.findElement(address_memory).sendKeys("Testing Frame 1");
		Thread.sleep(1000);
		
		//Switch from Frame 1 to Frame 2 to access the element present in frame 2
		driver.switchTo().frame("pact2");
		driver.findElement(address_dare).sendKeys("Testing Frame 2");
		
		//Switch from Frame 2 to Frame 3 to access the element inside frame 3
		driver.switchTo().frame("pact3");
		driver.findElement(address_heaven).sendKeys("Testing Frame 3");
		
		//Requirement : Switching Back from child parent to immediate parent. (Frame 3 -> Frame 2)
		//NoSuchElementException. We can't backworkd with switchTo.frame
		//driver.switchTo().frame("pact2");
		//driver.findElement(address_dare).sendKeys("Testing Frame 2");
		
		//Currently driver in Frame 3 and using parentframe method it back wards to its immediate parent
		driver.switchTo().parentFrame();
		driver.findElement(address_dare).sendKeys("Testing Frame 2");
		
		//Switching from Frame 2 --> Frame 1
		driver.switchTo().parentFrame();
		driver.findElement(address_memory).sendKeys("Testing Frame 1");
		
		//Imp : Frame 1 ---> Main Page
		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Memory')]")).getText());
		
		driver.close();		
		//driver.switchTo().defaultContent() -- No Matter the pointer is it directly jumps to main page.
		
	}

}
