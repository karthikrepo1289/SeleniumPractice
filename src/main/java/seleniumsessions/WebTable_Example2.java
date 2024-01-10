package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Example2 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		
		//Enter UserName and Password
		driver.findElement(By.name("username")).sendKeys("apiautomation");
		driver.findElement(By.name("password")).sendKeys("selenium@12345");
		
		//Click Login button.
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//Wait for 5 seconds
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		
		//Click Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Select the checkbox 
		selectContactCheckbox("Josh Buttler");
		
		//Find the companyname
		System.out.println(findCompanyName("Josh Buttler"));
		
		//Find Phone 
		System.out.println(findPhoneNumber("Josh Buttler"));
		
		//Find Email Address
		System.out.println(findEmail("Josh Buttler"));
		
		//Close the Browser
		driver.close();
	}

	public static void selectContactCheckbox(String contactName) {
		//a[contains(text(),'Josh Buttler')]/parent::td/preceding-sibling::td/input[@type='checkbox']
		String address = "//a[contains(text(),'"+contactName+"')]/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(address)).click();
	}
	
	public static String findCompanyName(String contactName) {
		String address="//a[contains(text(),'"+contactName+"')]/parent::td/following-sibling::td//a[@context='company']";
		return driver.findElement(By.xpath(address)).getText();
	}
	
	public static String findPhoneNumber(String contactName) {
		String address="//a[contains(text(),'"+contactName+"')]/parent::td/following-sibling::td[2]//span[@context='phone']";
		return driver.findElement(By.xpath(address)).getText();
	}
	
	public static String findEmail(String contactName) {
		String address="//a[contains(text(),'"+contactName+"')]/parent::td/following-sibling::td[5]/a";
		return driver.findElement(By.xpath(address)).getText();
	}
}
