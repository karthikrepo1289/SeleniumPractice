package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IFrameHandling {
	public static WebDriver driver;
	public static By address_proposal = By.id("RESULT_TextField-1");
	public static By address_location = By.id("RESULT_TextField-3");
	public static By address_proposedDate = By.id("RESULT_TextField-4");
	public static By address_description = By.id("RESULT_TextArea-5");
	public static By address_fileupload = By.id("RESULT_FileUpload-6");
	public static By address_firstName = By.id("RESULT_TextField-8");
	public static By address_lastName = By.id("RESULT_TextField-9");
	public static By address_street = By.id("RESULT_TextField-10");
	public static By address_city = By.id("RESULT_TextField-12");
	public static By address_state = By.id("RESULT_RadioButton-13");
	public static By address_zipcode = By.id("RESULT_TextField-14");
	public static By address_phoneNumber = By.id("RESULT_TextField-15");
	public static By address_email = By.id("RESULT_TextField-16");
	public static By address_header = By.xpath("//h3[text()='Vehicle Registration Form']");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Driver is inside page
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.findElement(By.id("imageTemplateContainer")).click();
		Thread.sleep(5000);

		// Driver is inside Frame
		driver.switchTo().frame("frame-one748593425");

		// Filling the form
		driver.findElement(address_proposal).sendKeys("Vehicle Proposal");
		driver.findElement(address_location).sendKeys("New York");
		driver.findElement(address_proposedDate).sendKeys("11/9/2023");
		driver.findElement(address_description).sendKeys("Testing");
		// Checked the attribute called type. It is having value as File
		driver.findElement(address_fileupload).sendKeys("C:\\Users\\srujan\\Desktop\\TEST.txt");
		driver.findElement(address_firstName).sendKeys("Raju");
		driver.findElement(address_lastName).sendKeys("Rajesh");
		driver.findElement(address_street).sendKeys("909 Fulton Street");
		driver.findElement(address_city).sendKeys("New York");

		WebElement select_element = driver.findElement(address_state);
		Select state = new Select(select_element);
		state.selectByVisibleText("New York");
		
		driver.findElement(address_zipcode).sendKeys("90879");
		driver.findElement(address_phoneNumber).sendKeys("61728288393");
		driver.findElement(address_email).sendKeys("test@gmail.com");
		
		//Get the title present inside a page but not inside frame.
		//NoSuchElementException as we didn't switch back to page.
		//String text = driver.findElement(address_header).getText();
		
		driver.switchTo().defaultContent();
		String text = driver.findElement(address_header).getText();
		System.out.println("Title "+text);
		
		driver.close();

	}

}
