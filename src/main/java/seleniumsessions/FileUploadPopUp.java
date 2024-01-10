package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadPopUp {

	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

		/** type = 'file' must be present in order to work with this solution */
		/** If not ask dev to addd this tag. **/
		/** 3rdd party like Robot, AutoIT **/
		WebElement btn = driver.findElement(By.xpath("//input[@name='upfile']"));
		btn.sendKeys("C:\\Users\\srujan\\Desktop\\TEST.txt");
	}

}
