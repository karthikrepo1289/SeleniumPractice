package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class Assignment_SelectContact {

	static WebDriver driver;
	static By address_username = By.name("username");
	static By address_password = By.name("password");
	static By address_login = By.cssSelector("input[value='Login']");
	static By address_menu_contact = By.linkText("CONTACTS");
	static String contactToSelect = "David Warner";
	static By address_select_contact = By.xpath("//a[text()='" + contactToSelect + "']");
	static By address_dropDown = By.xpath("//select[@name='do_action']");
	static String valToChoose = "";
	static By address_doButton = By.cssSelector("input[value='DO']");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");

		driver.findElement(address_username).sendKeys("apiautomation");
		driver.findElement(address_password).sendKeys("selenium@12345");
		driver.findElement(address_login).click();

		driver.switchTo().frame("mainpanel");
		driver.findElement(address_menu_contact).click();
		Thread.sleep(3000);
		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(address_select_contact)).click();

		Select operate_Contact = new Select(driver.findElement(address_dropDown));
		operate_Contact.selectByVisibleText("Delete Checked");
		driver.findElement(address_doButton).click();
		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		System.out.println(driver.getCurrentUrl());
	}
}
