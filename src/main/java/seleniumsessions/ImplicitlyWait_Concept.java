package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWait_Concept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("");
		
		//Dynamic Wait - Implicitly Wait (Global Wait applicable only for WebElements)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/**
		 * element 1 : By default it applies 10 sec
		 * element 2 : By default it applies 10 sec
		 * 
		 * The moment we write driver.findElement - Implicitly Wait applied internally
		 * So every time driver.findElement triggers implicitlyWait and implicitlyWait checks the element on webpage and ignores the extra time if it is able to find before the time that specified
		 * Due to this every time we write driver.findElement instead of directly searching on webpage, first it triggers implicitlywait from that it checks
		 * 
		 */
	}

}
